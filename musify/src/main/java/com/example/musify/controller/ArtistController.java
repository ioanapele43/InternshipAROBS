package com.example.musify.controller;

import com.example.musify.dto.ArtistDTO;
import com.example.musify.dto.ArtistViewDTO;
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
    public List<ArtistViewDTO> getAllArtist() {
        return artistService.getArtists();
    }

    @GetMapping("/artists/{id}")
    public ArtistViewDTO getArtistByID(@PathVariable Integer id) {
        return artistService.getArtistById(id);
    }

    @PostMapping("/artist/create")
    public ArtistViewDTO saveArtist(@RequestBody @Valid ArtistDTO artistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return artistService.saveArtist(artistDTO);
    }

    @PutMapping("/artist/{id}/update")
    public ArtistViewDTO updateArtist(@PathVariable Integer id, @RequestBody @Valid ArtistDTO artistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return artistService.updateArtist(id, artistDTO);
    }

    @DeleteMapping("/artist/{id}/delete")
    public void deleteArtist(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        artistService.deleteArtist(id);
    }
}
