package com.example.musify.controller;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/artist/create")
    public String saveArtist(@RequestBody @Valid ArtistDTO artistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        artistService.saveArtist(artistDTO);
        return "Success!";
    }

    @PutMapping("/artist/{id}/update")
    public String updateArtist(@PathVariable Integer id, @RequestBody @Valid ArtistDTO artistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        artistService.updateArtist(id, artistDTO);
        return "Success!";
    }

    @DeleteMapping("/artist/{id}/delete")
    public String deleteArtist(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        artistService.deleteArtist(id);
        return "Success!";
    }
}
