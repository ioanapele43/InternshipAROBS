package com.example.musify.service;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.exception.DataNotFoundException;
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
                .map(a-> albumMapper.toViewDto(a))
                .collect(Collectors.toList());
    }

    public Album getAlbumById(Integer id) {
        return albumRepositoryJPA.getAlbumById(id);
    }

    @Transactional
    public void createAlbum(AlbumDTO albumDTO) throws DataNotFoundException {
        Album album=albumMapper.toEntity(albumDTO);
        if(albumDTO.getIdBand()!=0 && albumDTO.getIdArtist()!=0)
            throw new DataNotFoundException("an album cannot have multiple owners, just an artist or a band");
        if(albumDTO.getIdArtist()!=0){
            if(artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist())==null)
                throw new DataNotFoundException("the artist you entered doesn't exists");
            album.setArtist(artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist()));
        }

        if(albumDTO.getIdBand()!=0) {
            if(bandRepositoryJPA.getBandById(albumDTO.getIdBand())==null)
                throw new DataNotFoundException("the band you entered doesn't exists");
            album.setBand(bandRepositoryJPA.getById(albumDTO.getIdBand()));
        }

        albumRepositoryJPA.save(album);
    }

    @Transactional
    public void updateAlbum(AlbumDTO albumDTO) {
        Album album=albumMapper.toEntity(albumDTO);
        if(albumDTO.getIdBand()!=0 && albumDTO.getIdArtist()!=0)
            throw new DataNotFoundException("an album cannot have multiple owners, just an artist or a band");
        if(albumDTO.getIdArtist()!=0){
            if(artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist())==null)
                throw new DataNotFoundException("the artist you entered doesn't exists");
            album.setArtist(artistRepositoryJPA.getArtistsById(albumDTO.getIdArtist()));
        }

        if(albumDTO.getIdBand()!=0) {
            if(bandRepositoryJPA.getBandById(albumDTO.getIdBand())==null)
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
    public List<SongDTO> getAlbumSongs(Integer id){
       return albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(id).stream().map(as->songMapper.toDto(as.getSong())).collect(Collectors.toList());
   }
   @Transactional
    public void addSongToAlbum(Integer idAlbum, Integer idSong){
        AlbumSongs albumSong=new AlbumSongs();
        albumSong.setSong(songRepositoryJPA.getSongById(idSong));
        albumSong.setAlbum(albumRepositoryJPA.getAlbumById(idAlbum));
        albumSong.setOrderNumber(albumSongsRepositoryJPA.getAlbumSongsByAlbum_Id(idAlbum).size());
        albumSongsRepositoryJPA.save(albumSong);
   }
}
