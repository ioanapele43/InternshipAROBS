package com.example.musify.service;

import com.example.musify.model.Artist;
import com.example.musify.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service

public class ArtistService {
    @Autowired
    private DataSource dataSource;
    private final ArtistRepository artistRepository;
    @Autowired
    public ArtistService(ArtistRepository artistRepository){
        this.artistRepository=artistRepository;
    }
    public List<Artist> getArtistis(){
        return artistRepository.findAll();
    }

}
