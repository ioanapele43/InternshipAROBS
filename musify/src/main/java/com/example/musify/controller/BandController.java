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
    public ResponseEntity<List<BandViewDTO>> getAllBands() {
        List<BandViewDTO> bands = bandService.getAllBands();
        return new ResponseEntity<>(bands, HttpStatus.OK);
    }

    @PostMapping("/band/create")
    public String createBand(@RequestBody @Valid BandDTO bandDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        bandService.createBand(bandDTO);
        return "Success!";
    }

    @PutMapping("/band/{id}/update")
    public String updateBand(@PathVariable Integer id, @RequestBody @Valid BandDTO bandDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        bandService.updateBand(id, bandDTO);
        return "Success!";
    }

    @DeleteMapping("/band/{id}/delete")
    public String deleteBand(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        bandService.deleteBand(id);
        return "Success!";
    }

    @PostMapping("/band/{idBand}/add_member/{idArtist}")
    public String addBandMember(@PathVariable Integer idBand, @PathVariable Integer idArtist) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        bandService.addBandMember(idBand, idArtist);
        return "success";
    }

    @GetMapping("/band/{id}/members")
    public ResponseEntity<List<ArtistViewDTO>> getBandMembers(@PathVariable Integer id) {
        List<ArtistViewDTO> artistViewDTOS = bandService.getBandMembers(id);
        return new ResponseEntity<>(artistViewDTOS, HttpStatus.OK);
    }


}
