package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.model.Artist;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.service.mappers.ArtistMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

public class ArtistService {
    private final ArtistRepositoryJPA artistRepository;
    private final ArtistMapper artistMapper;

    public ArtistService( ArtistRepositoryJPA artistRepository, ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }


    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(int id) {
        return artistRepository.findById(id);
    }

    ;

    public Optional<Artist> getArtistContaining(String firstName) {

        Optional<Artist> artist = artistRepository.findByFirstname(firstName);
        return artist;
    }

    @Transactional
    public void saveArtist(ArtistDTO artist) {
        artistRepository.save(artistMapper.toEntity(artist));
    }

    @Transactional
    public void updateArtist(ArtistDTO artist) {
        artistRepository.save(artistMapper.toEntity(artist));
    }

    @Transactional
    public void deleteArtist(ArtistDTO artist) {
        artistRepository.delete(artistMapper.toEntity(artist));
    }


}
