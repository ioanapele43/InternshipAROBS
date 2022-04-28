package com.example.musify.controller;

import com.example.musify.dto.*;
import com.example.musify.model.Album;
import com.example.musify.model.Artist;
import com.example.musify.model.Band;
import com.example.musify.service.AlbumService;
import com.example.musify.service.ArtistService;
import com.example.musify.service.BandService;
import com.example.musify.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private SearchService searchService;

    @GetMapping("/search/artists")
    public List<ArtistViewDTO> searchByLastName(@RequestParam String input) {
        return searchService.searchByName(input);
    }

    @GetMapping("/search/albums/by_title")
    public List<AlbumViewDTO> searchByTitle(@RequestParam String input) {
        return searchService.searchByTitle(input);
    }

    @GetMapping("/search/bands/by_bandname")
    public List<BandViewDTO> searchByBandName(@RequestParam String input) {
        return searchService.searchByBandname(input);
    }
    @GetMapping("/search/songs")
    public List<SongViewDTO> searchTitleByTitle(@RequestParam String input){
        return searchService.searchSongByTitle(input);
    }

    @GetMapping("/searchAll")
    public ResponseEntity<SearchDTO> searchAll(String input) {
        SearchDTO searchDTO = searchService.searchAll(input);
        return new ResponseEntity<>(searchDTO, HttpStatus.OK);
    }

}
