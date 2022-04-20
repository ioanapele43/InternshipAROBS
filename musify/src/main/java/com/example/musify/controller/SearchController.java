package com.example.musify.controller;

import com.example.musify.model.Album;
import com.example.musify.model.Artist;
import com.example.musify.model.Band;
import com.example.musify.service.AlbumService;
import com.example.musify.service.ArtistService;
import com.example.musify.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {
    @Autowired
    private ArtistService artistService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private BandService bandService;
    @GetMapping("/search/artists/firstname")
    public ResponseEntity<Optional<List<Artist>>> searchByFirstName(@RequestParam String input){
        Optional<List<Artist>> artists= artistService.searchByFirstName(input);
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
    @GetMapping("/search/artists/lastname")
    public List<Artist> searchByLastName(@RequestParam String input){
        return artistService.searchByLastName(input);
    }
    @GetMapping("/search/albums/title")
    public List<Album> searchByTitle(@RequestParam String input){
        return albumService.searchByTitle(input);
    }
    @GetMapping("/search/bands/bandname")
    public List<Band> searchByBandName(@RequestParam String input){
        return bandService.searchByBandname(input);
    }

}
