package com.example.musify.controller;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.model.Artist;
import com.example.musify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllArtist() {
        List<Artist> artists = artistService.getArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<Artist> getArtistByID(@PathVariable Integer id) {
        Artist artist = artistService.getArtistById(id);
        return new ResponseEntity<Artist>(artist, HttpStatus.OK);
    }

    @GetMapping("/artist/{firstName}")
    public ResponseEntity<Optional<Artist>> getArtistByFirstNameLike(@PathVariable String firstName) {
        Optional<Artist> artists = artistService.getArtistContaining(firstName);
        return new ResponseEntity<Optional<Artist>>(artists, HttpStatus.OK);
    }

    @PostMapping("/artist/save")
    public String saveArtist(@RequestBody ArtistDTO artistDTO) {
        artistService.saveArtist(artistDTO);
        return "Success!";
    }

    @PutMapping("/artist/update")
    public String updateArtist(@RequestBody ArtistDTO artistDTO) {
        artistService.updateArtist(artistDTO);
        return "Success!";
    }

    @DeleteMapping("/artist/delete/{id}")
    public String deleteArtist(@PathVariable Integer id) {
        ArtistDTO artistDTO = new ArtistDTO();
        artistDTO.setId(id);
        artistService.deleteArtist(artistDTO);
        return "Success!";
    }
    /*@GetMapping("/artist/search")
    public Optional<Artist> searchForAnArtist(@RequestParam String name){
        Optional<Artist> artist=artistService.searchArtist(name);
        return artist;
    }*/
}
