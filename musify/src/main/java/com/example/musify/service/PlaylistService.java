package com.example.musify.service;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.exception.AlreadyExistingDataException;
import com.example.musify.exception.PrivatePlaylistException;
import com.example.musify.exception.WrongInputException;
import com.example.musify.model.*;
import com.example.musify.repo.*;
import com.example.musify.security.JwtUtils;
import com.example.musify.service.mappers.PlaylistMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {
    private final PlaylistRepositoryJPA playlistRepositoryJPA;
    private final SongRepositoryJPA songRepositoryJPA;
    private final AlbumSongsRepositoryJPA albumSongsRepositoryJPA;
    private final PlaylistSongsRepositoryJPA playlistSongsRepositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;
    private final PlaylistMapper playlistMapper;
    private final ValidationsService validationsService;


    public PlaylistService(PlaylistRepositoryJPA playlistRepositoryJPA, SongRepositoryJPA songRepositoryJPA, AlbumSongsRepositoryJPA albumSongsRepositoryJPA, PlaylistSongsRepositoryJPA playlistSongsRepositoryJPA, UserRepositoryJPA userRepositoryJPA, PlaylistMapper playlistMapper, ValidationsService validationsService) {
        this.playlistRepositoryJPA = playlistRepositoryJPA;
        this.songRepositoryJPA = songRepositoryJPA;
        this.albumSongsRepositoryJPA = albumSongsRepositoryJPA;
        this.playlistSongsRepositoryJPA = playlistSongsRepositoryJPA;
        this.userRepositoryJPA = userRepositoryJPA;
        this.playlistMapper = playlistMapper;
        this.validationsService = validationsService;
    }

    public List<PlaylistViewDTO> getAllPlaylists() {
        return playlistRepositoryJPA.findAll().stream().map(p -> playlistMapper.toViewDto(p)).collect(Collectors.toList());
    }

    public PlaylistViewDTO getPlaylistbyId(Integer id) {
        validationsService.checkIfAPlaylistExists(id);
        validationsService.checkIfAUserCanAccessAPlaylist(id);
        return playlistMapper.toViewDto(playlistRepositoryJPA.getPlaylistById(id));
    }

    @Transactional
    public void createPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = playlistMapper.toEntity(playlistDTO);
        playlist.setOwner(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()));
        playlist.addFollower(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()));
        Playlist playlistsaved = playlistRepositoryJPA.save(playlist);
        //System.out.println(playlistsaved.getId());
        userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()).addPlaylistCreated(playlistsaved);
    }

    @Transactional
    public void updatePlaylist(Integer id, PlaylistDTO playlistDTO) {
        validationsService.checkIfAPlaylistExists(id);
        Playlist playlist = playlistMapper.toEntity(playlistDTO);
        playlist.setId(id);
        playlist.setOwner(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()));
        playlistRepositoryJPA.save(playlist);
    }

    @Transactional
    public void deletePlaylist(Integer id) {
        validationsService.checkIfAPlaylistExists(id);
        playlistRepositoryJPA.delete(playlistRepositoryJPA.getPlaylistById(id));
    }

    @Transactional
    public void addSongToPlaylist(Integer idPlaylist, Integer idSong) {
        validationsService.checkIfAPlaylistExists(idPlaylist);
        validationsService.checkIfAUserIsTheOwnerOfAPlaylist(idPlaylist);
        validationsService.checkIfASongExists(idSong);
        validationsService.checkIfASongIsNOTInAPlaylist(idPlaylist, idSong);

        PlaylistSongs playlistSongs = new PlaylistSongs();
        playlistSongs.setPlaylist(playlistRepositoryJPA.getPlaylistById(idPlaylist));
        playlistSongs.setSong(songRepositoryJPA.getSongById(idSong));
        playlistSongs.setOrderNumber(playlistSongsRepositoryJPA.getPlaylistSongsByPlaylist_Id(idPlaylist).size() + 1);
        playlistSongsRepositoryJPA.save(playlistSongs);
    }

    @Transactional
    public List<PlaylistViewDTO> getPlaylistCreatedByTheCurrentUser() {
        User user = userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId());
        return user.getPlaylistsCreated().stream().map(playlist -> playlistMapper.toViewDto(playlist)).collect(Collectors.toList());
    }

    @Transactional
    public List<PlaylistViewDTO> getPlaylistFollowedByTheCurrentUser() {
        User user = userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId());
        return user.getPlaylistsFollowed().stream().map(playlist -> playlistMapper.toViewDto(playlist)).collect(Collectors.toList());
    }

    @Transactional
    public void followPlaylistByCurrentUser(Integer idPlaylist) {
        validationsService.checkIfAPlaylistExists(idPlaylist);
        validationsService.checkIfAUserCanAccessAPlaylist(idPlaylist);
        if(!playlistRepositoryJPA.getPlaylistById(idPlaylist).getUsersWhoFollows().contains(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId())))
            playlistRepositoryJPA.getPlaylistById(idPlaylist).addFollower(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()));
    }
    @Transactional
    public void unfollowPlaylistByCurrentUser(Integer idPlaylist) {
        validationsService.checkIfAPlaylistExists(idPlaylist);
        if(playlistRepositoryJPA.getPlaylistById(idPlaylist).getOwner()==userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()))
            throw new WrongInputException("you can't unfollow a playlist you created");
        if(playlistRepositoryJPA.getPlaylistById(idPlaylist).getUsersWhoFollows().contains(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId())))
            playlistRepositoryJPA.getPlaylistById(idPlaylist).removeFollower(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()));
    }
    @Transactional
    public void addAlbumSongsToPlaylist(Integer idPlaylist, Integer idAlbum) {
        validationsService.checkIfAPlaylistExists(idPlaylist);
        validationsService.checkIfAnAlbumExists(idAlbum);
        validationsService.checkIfAUserCanAccessAPlaylist(idPlaylist);
        List<Song> songs = albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(idAlbum).stream().map(as -> as.getSong()).collect(Collectors.toList());
        songs.forEach(song -> {
            if(playlistSongsRepositoryJPA.getPlaylistSongsByPlaylist_IdAndSong_Id(idPlaylist,song.getId())==null){
                addSongToPlaylist(idPlaylist, song.getId());
            }
        });
    }

    @Transactional
    public void changeSongOrderNumber(Integer idPlaylist, Integer idSong, Integer newOrderNumber) {
        validationsService.checkIfAPlaylistExists(idPlaylist);
        validationsService.checkIfASongExists(idSong);
        validationsService.checkIfASongIsInAPlaylist(idPlaylist, idSong);
        validationsService.checkIfAUserIsTheOwnerOfAPlaylist(idPlaylist);

        Integer oldOrderNumber = playlistSongsRepositoryJPA.getPlaylistSongsByPlaylist_IdAndSong_Id(idPlaylist, idSong).getOrderNumber();
        List<PlaylistSongs> playlistSongs = playlistSongsRepositoryJPA.getPlaylistSongsByPlaylist_Id(idPlaylist);
        if (playlistSongs.size() < newOrderNumber)
            throw new WrongInputException("New order number is too large");
        playlistSongs.forEach(playlistSong -> {
            if (oldOrderNumber < newOrderNumber) {
                if (playlistSong.getOrderNumber() > oldOrderNumber && playlistSong.getOrderNumber() <= newOrderNumber)
                    playlistSong.setOrderNumber(playlistSong.getOrderNumber() - 1);
            } else {
                if (playlistSong.getOrderNumber() < oldOrderNumber && playlistSong.getOrderNumber() >= newOrderNumber) {
                    playlistSong.setOrderNumber(playlistSong.getOrderNumber() + 1);
                }
            }
        });
        albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idPlaylist, idSong).setOrderNumber(newOrderNumber);
    }


}
