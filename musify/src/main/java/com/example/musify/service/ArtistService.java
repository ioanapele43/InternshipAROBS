package com.example.musify.service;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.model.Artist;
import com.example.musify.repo.ArtistRepositoryJPA;
import com.example.musify.service.mappers.ArtistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ArtistService {
    @Autowired
    private DataSource dataSource;
    private final ArtistRepositoryJPA artistRepository;
    @Autowired
    private ArtistMapper artistMapper;
    @Autowired
    public ArtistService(ArtistRepositoryJPA artistRepository){
        this.artistRepository=artistRepository;
    }

    public List<Artist> getArtists(){
        return artistRepository.findAll();
    }
    public Optional<Artist> getArtistById(int id){return artistRepository.findById(id);};

    public Optional<Artist> getArtistContaining(String firstName){

        Optional<Artist> artist=artistRepository.findByFirstname(firstName);
        return artist;
    }
    @Transactional
    public void saveArtist(ArtistDTO artist){
        artistRepository.save(artistMapper.toEntity(artist));
    }
    @Transactional
    public void updateArtist(ArtistDTO artist){
        artistRepository.save(artistMapper.toEntity(artist));
    }
    @Transactional
    public void deleteArtist(ArtistDTO artist){
        artistRepository.delete(artistMapper.toEntity(artist));
    }


}
