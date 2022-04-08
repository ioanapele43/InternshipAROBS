package com.example.musify.service;

import com.example.musify.model.Artist;
import com.example.musify.repo.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Artist> getArtistById(int id){return artistRepository.findAllById(Collections.singleton(id));};

    public List<Artist> getArtistContaining(String s){

        List<Artist> artists=artistRepository.findAll().stream()
                .filter(x-> x.getFirstName().contains(s) )
                .collect(Collectors.toList());
        return artists;
    }

    public void saveArtist(Artist a){
        artistRepository.save(a);
    }
    public void updateArtist(String firstName, String lastName, int id){
        //artistRepository.setFirstname(firstName,lastName,id);
    }

}
