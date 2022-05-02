package com.example.musify.controller;

import com.example.musify.dto.ArtistViewDTO;
import com.example.musify.dto.BandDTO;
import com.example.musify.dto.BandViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BandController {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private BandService bandService;


    @GetMapping("/bands")
    public List<BandViewDTO> getAllBands() {
        return bandService.getAllBands();
    }

    @PostMapping("/band/create")
    public BandViewDTO createBand(@RequestBody @Valid BandDTO bandDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return bandService.createBand(bandDTO);
    }

    @PutMapping("/band/{id}/update")
    public BandViewDTO updateBand(@PathVariable Integer id, @RequestBody @Valid BandDTO bandDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return bandService.updateBand(id, bandDTO);
    }

    @DeleteMapping("/band/{id}/delete")
    public void deleteBand(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        bandService.deleteBand(id);
    }

    @PostMapping("/band/{idBand}/add_member/{idArtist}")
    public List<ArtistViewDTO> addBandMember(@PathVariable Integer idBand, @PathVariable Integer idArtist) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return bandService.addBandMember(idBand, idArtist);
    }

    @GetMapping("/band/{id}/members")
    public List<ArtistViewDTO> getBandMembers(@PathVariable Integer id) {
        return bandService.getBandMembers(id);
    }


}
