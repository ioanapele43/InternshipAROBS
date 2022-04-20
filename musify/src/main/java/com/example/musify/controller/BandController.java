package com.example.musify.controller;

import com.example.musify.dto.BandDTO;
import com.example.musify.model.Album;
import com.example.musify.model.Band;
import com.example.musify.repo.BandRepositoryJPA;
import com.example.musify.service.BandService;
import com.example.musify.service.mappers.BandMapper;
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
    public ResponseEntity<List<Band>> getAllBands() {
        List<Band> bands=bandService.getAllBands();
        return new ResponseEntity<>(bands, HttpStatus.OK);
    }
    @PostMapping("/band/create")
    public String createBand(@RequestBody @Valid BandDTO bandDTO){
        bandService.createBand(bandDTO);
        return "Success!";
    }
    @PutMapping("/band/update")
    public String updateBand(@RequestBody @Valid BandDTO bandDTO){
        bandService.updateBand(bandDTO);
        return "Success!";
    }
    @DeleteMapping("/band/delete/{id}")
    public String deleteBand(@PathVariable Integer id){
        BandDTO bandDTO=new BandDTO();
        bandDTO.setId(id);
        bandService.deleteBand(bandDTO);
        return "Success!";
    }


}
