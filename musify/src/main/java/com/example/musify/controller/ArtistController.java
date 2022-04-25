package com.example.musify.controller;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.model.Artist;
import com.example.musify.service.ArtistService;
import com.example.musify.service.mappers.ArtistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistViewDTO>> getAllArtist() {
        List<ArtistViewDTO> artists = artistService.getArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/artists/{id}")
    public ResponseEntity<ArtistViewDTO> getArtistByID(@PathVariable Integer id) {
        ArtistViewDTO artist = artistService.getArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping("/artist/save")
    public String saveArtist(@RequestBody ArtistDTO artistDTO) {
        artistService.saveArtist(artistDTO);
        return "Success!";
    }

    @PutMapping("/artist/update")
    public String updateArtist(@RequestBody ArtistDTO artistDTO) {
        try {
            artistService.updateArtist(artistDTO);
            return "Success!";
        } catch (DataNotFoundException e) {
            return e.getLocalizedMessage();
        }
    }

    @DeleteMapping("/artist/delete/{id}")
    public String deleteArtist(@PathVariable Integer id) {
        try {
            ArtistDTO artistDTO = new ArtistDTO();
            artistDTO.setId(id);
            artistService.deleteArtist(artistDTO);
            return "Success!";
        } catch (DataNotFoundException e) {
            return e.getLocalizedMessage();
        }

    }
}
