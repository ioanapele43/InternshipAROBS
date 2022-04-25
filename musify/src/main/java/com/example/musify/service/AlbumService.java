package com.example.musify.service;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.exception.AlreadyExistingDataException;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.exception.WrongInputException;
import com.example.musify.model.Album;
import com.example.musify.model.AlbumSongs;
import com.example.musify.repo.*;
import com.example.musify.service.mappers.AlbumMapper;
import com.example.musify.service.mappers.SongMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {
    private final AlbumRepositoryJPA albumRepositoryJPA;
    private final ArtistRepositoryJPA artistRepositoryJPA;
    private final BandRepositoryJPA bandRepositoryJPA;
    private final AlbumSongsRepositoryJPA albumSongsRepositoryJPA;
    private final SongRepositoryJPA songRepositoryJPA;
    private final AlbumMapper albumMapper;
    private final SongMapper songMapper;


    public AlbumService(AlbumRepositoryJPA albumRepositoryJPA, ArtistRepositoryJPA artistRepositoryJPA, BandRepositoryJPA bandRepositoryJPA, AlbumSongsRepositoryJPA albumSongsRepositoryJPA, SongRepositoryJPA songRepositoryJPA, AlbumMapper albumMapper, SongMapper songMapper) {
        this.albumRepositoryJPA = albumRepositoryJPA;
        this.artistRepositoryJPA = artistRepositoryJPA;
        this.bandRepositoryJPA = bandRepositoryJPA;
        this.albumSongsRepositoryJPA = albumSongsRepositoryJPA;
        this.songRepositoryJPA = songRepositoryJPA;
        this.albumMapper = albumMapper;

        this.songMapper = songMapper;
    }

    public List<AlbumViewDTO> getAllAlbums() {
        return albumRepositoryJPA.findAll().stream()
                .map(a -> albumMapper.toViewDto(a))
                .collect(Collectors.toList());
    }

    public List<AlbumViewDTO> getAllAlbumsByArtist(Integer idArtist) {
        return albumRepositoryJPA.getAlbumsByArtist_Id(idArtist).stream()
                .map(a -> albumMapper.toViewDto(a))
                .collect(Collectors.toList());
    }

    public List<AlbumViewDTO> getAllAlbumsByBand(Integer idBand) {
        return albumRepositoryJPA.getAlbumsByBand_Id(idBand).stream()
                .map(a -> albumMapper.toViewDto(a))
                .collect(Collectors.toList());
    }

    public Album getAlbumById(Integer id) {
        return albumRepositoryJPA.getAlbumById(id);
    }

    @Transactional
    public void createAlbum(AlbumDTO albumDTO) throws DataNotFoundException {
        Album album = albumMapper.toEntity(albumDTO);
        if (albumDTO.getIdBand() != 0 && albumDTO.getIdArtist() != 0)
            throw new DataNotFoundException("an album cannot have multiple owners, just an artist or a band");
        if (albumDTO.getIdBand() == 0 && albumDTO.getIdArtist() == 0)
            throw new WrongInputException("an album should have at least one owner, artist or band");
        if (albumDTO.getIdArtist() != 0) {
            if (artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist()) == null)
                throw new DataNotFoundException("the artist you entered doesn't exists");
            album.setArtist(artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist()));
        }

        if (albumDTO.getIdBand() != 0) {
            if (bandRepositoryJPA.getBandById(albumDTO.getIdBand()) == null)
                throw new DataNotFoundException("the band you entered doesn't exists");
            album.setBand(bandRepositoryJPA.getById(albumDTO.getIdBand()));
        }

        albumRepositoryJPA.save(album);
    }

    @Transactional
    public void updateAlbum(AlbumDTO albumDTO) {
        if (albumRepositoryJPA.getAlbumById(albumDTO.getId()) == null)
            throw new DataNotFoundException("the album you want to update doesn't exist");
        Album album = albumMapper.toEntity(albumDTO);
        if (albumDTO.getIdBand() != 0 && albumDTO.getIdArtist() != 0)
            throw new DataNotFoundException("an album cannot have multiple owners, just an artist or a band");
        if (albumDTO.getIdArtist() != 0) {
            if (artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist()) == null)
                throw new DataNotFoundException("the artist you entered doesn't exists");
            album.setArtist(artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist()));
        }

        if (albumDTO.getIdBand() != 0) {
            if (bandRepositoryJPA.getBandById(albumDTO.getIdBand()) == null)
                throw new DataNotFoundException("the band you entered doesn't exists");
            album.setBand(bandRepositoryJPA.getById(albumDTO.getIdBand()));
        }

        albumRepositoryJPA.save(album);
    }

    @Transactional
    public void deleteAlbum(AlbumDTO albumDTO) {
        albumRepositoryJPA.delete(albumMapper.toEntity(albumDTO));
    }

    @Transactional
    public List<SongDTO> getAlbumSongs(Integer id) {
        return albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(id).stream().map(as -> songMapper.toDto(as.getSong())).collect(Collectors.toList());
    }

    @Transactional
    public void addSongToAlbum(Integer idAlbum, Integer idSong) {
        AlbumSongs albumSong = new AlbumSongs();
        if (songRepositoryJPA.getSongById(idSong) == null)
            throw new DataNotFoundException("The song you entered doesn't exist");
        if (albumRepositoryJPA.getAlbumById(idAlbum) == null)
            throw new DataNotFoundException("the album you entered doesn't exist");
        if (albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idAlbum, idSong) != null)
            throw new AlreadyExistingDataException("this song is already in the album");
        albumSong.setSong(songRepositoryJPA.getSongById(idSong));
        albumSong.setAlbum(albumRepositoryJPA.getAlbumById(idAlbum));
        albumSong.setOrderNumber(albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(idAlbum).size() + 1);
        albumSongsRepositoryJPA.save(albumSong);
    }

    @Transactional
    public void changeSongOrderNumber(Integer idAlbum, Integer idSong, Integer newOrderNumber) {

        if (songRepositoryJPA.getSongById(idSong) == null)
            throw new DataNotFoundException("The song you entered doesn't exist");
        if (albumRepositoryJPA.getAlbumById(idAlbum) == null)
            throw new DataNotFoundException("The album you entered doesn't exist");
        if (albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idAlbum, idSong) == null)
            throw new DataNotFoundException("The data you want to modify doesn't exist");
        Integer oldOrderNumber = albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idAlbum, idSong).getOrderNumber();
        List<AlbumSongs> albumSongs = albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(idAlbum);
        if (albumSongs.size() < newOrderNumber)
            throw new WrongInputException("New order number is too large");
        albumSongs.forEach(album -> {
            if (oldOrderNumber < newOrderNumber) {
                if (album.getOrderNumber() > oldOrderNumber && album.getOrderNumber() <= newOrderNumber)
                    album.setOrderNumber(album.getOrderNumber() - 1);
            } else {
                if (album.getOrderNumber() < oldOrderNumber && album.getOrderNumber() >= newOrderNumber) {
                    album.setOrderNumber(album.getOrderNumber() + 1);
                }
            }
        });
        albumSongsRepositoryJPA.getAlbumSongsByAlbum_IdAndSong_id(idAlbum, idSong).setOrderNumber(newOrderNumber);
    }
}
