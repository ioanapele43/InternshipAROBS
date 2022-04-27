package com.example.musify.service;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.model.Playlist;
import com.example.musify.model.PlaylistSongs;
import com.example.musify.model.User;
import com.example.musify.repo.PlaylistRepositoryJPA;
import com.example.musify.repo.PlaylistSongsRepositoryJPA;
import com.example.musify.repo.SongRepositoryJPA;
import com.example.musify.repo.UserRepositoryJPA;
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
    private final PlaylistSongsRepositoryJPA playlistSongsRepositoryJPA;
    private final UserRepositoryJPA userRepositoryJPA;
    private final PlaylistMapper playlistMapper;



    public PlaylistService(PlaylistRepositoryJPA playlistRepositoryJPA, SongRepositoryJPA songRepositoryJPA, PlaylistSongsRepositoryJPA playlistSongsRepositoryJPA, UserRepositoryJPA userRepositoryJPA, PlaylistMapper playlistMapper) {
        this.playlistRepositoryJPA = playlistRepositoryJPA;
        this.songRepositoryJPA = songRepositoryJPA;
        this.playlistSongsRepositoryJPA = playlistSongsRepositoryJPA;
        this.userRepositoryJPA = userRepositoryJPA;
        this.playlistMapper = playlistMapper;
    }

    public List<PlaylistViewDTO> getAllPlaylists() {
        return playlistRepositoryJPA.findAll().stream().map(p -> playlistMapper.toViewDto(p)).collect(Collectors.toList());
    }

    public PlaylistViewDTO getPlaylistbyId(Integer id) {
        return playlistMapper.toViewDto(playlistRepositoryJPA.getPlaylistById(id));
    }

    @Transactional
    public void createPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist=playlistMapper.toEntity(playlistDTO);
        playlist.setOwner(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()));
        playlist.addFollower(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()));
        Playlist playlistsaved=playlistRepositoryJPA.save(playlist);
        //System.out.println(playlistsaved.getId());

        userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()).addPlaylistCreated(playlistsaved);


    }

    @Transactional
    public void updatePlaylist(PlaylistDTO playlistDTO) {
        playlistRepositoryJPA.save(playlistMapper.toEntity(playlistDTO));
    }

    @Transactional
    public void deletePlaylist(PlaylistDTO playlistDTO) {
        playlistRepositoryJPA.delete(playlistMapper.toEntity(playlistDTO));
    }
    @Transactional
    public void addSongToPlaylist(Integer idPlaylist, Integer idSong){
        PlaylistSongs playlistSongs=new PlaylistSongs();
        playlistSongs.setPlaylist(playlistRepositoryJPA.getPlaylistById(idPlaylist));
        playlistSongs.setSong(songRepositoryJPA.getSongById(idSong));
        playlistSongsRepositoryJPA.save(playlistSongs);
    }
    @Transactional
    public List<PlaylistDTO> getPlaylistCreatedByTheCurrentUser(){
        User user=userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId());
        return user.getPlaylistsCreated().stream().map(playlist -> playlistMapper.toDto(playlist)).collect(Collectors.toList());
    }
    @Transactional
    public List<PlaylistDTO> getPlaylistFollowedByTheCurrentUser(){
        User user=userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId());
        return user.getPlaylistsFollowed().stream().map(playlist -> playlistMapper.toDto(playlist)).collect(Collectors.toList());
    }
    @Transactional
    public void followPlaylistByCurrentUser(Integer idPlaylist){
       playlistRepositoryJPA.getPlaylistById(idPlaylist).addFollower(userRepositoryJPA.getUserById(JwtUtils.getCurrentUserId()));
    }


}
