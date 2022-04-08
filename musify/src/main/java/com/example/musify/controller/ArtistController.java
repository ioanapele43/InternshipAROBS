package com.example.musify.controller;

import com.example.musify.model.Artist;
import com.example.musify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {
    private final  ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService){
        this.artistService=artistService;
    }

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtist(){
        List<Artist> artists=artistService.getArtistis();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
    @GetMapping("/artistsById")
    public ResponseEntity<List<Artist>> getArtistByID(@RequestParam int id){
        List<Artist> artists=artistService.getArtistById(id);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

}
