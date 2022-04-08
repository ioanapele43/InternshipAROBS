package com.example.musify.controller;

import com.example.musify.model.Artist;
import com.example.musify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
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
    @GetMapping("/artistByFirstName")
    public ResponseEntity<List<Artist>> getArtistByFirstNameLike(@RequestParam String s){
        List<Artist> artists=artistService.getArtistContaining(s);
        return new ResponseEntity<>(artists,HttpStatus.OK);
    }

    @PostMapping("/artistSave")
    public void saveArtist(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Date activity_start_date, @RequestParam Date activity_end_date, @RequestParam Date birthday, @RequestParam String stageName){
        artistService.saveArtist(new Artist(firstName,lastName,stageName,birthday,activity_start_date,activity_end_date));
    }
}
