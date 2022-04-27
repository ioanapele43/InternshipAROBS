package com.example.musify.controller;


import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.repo.jdbc.SongRepositoty;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.AlternativeTitlesService;
import com.example.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class SongController {
    @Autowired
    private SongRepositoty songRepositoty;
    @Autowired
    private SongService songService;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AlternativeTitlesService alternativeTitlesService;


    @GetMapping("/songs")
    public ResponseEntity<List<SongViewDTO>> getAllPlaylists() {
        List<SongViewDTO> song = songService.getAllSongs();
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<SongViewDTO> getPlaylistById(Integer id) {
        SongViewDTO song = songService.getSongById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @PostMapping("/song/create")
    public String createSong(@RequestBody @Valid SongDTO songDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        songService.createSong(songDTO);
        return "success!";
    }

    @PutMapping("/song/{id}/update")
    public String updateSong(@PathVariable Integer id,@RequestBody @Valid SongDTO songDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        songService.updateSong(id,songDTO);
        return "success!";
    }

    @DeleteMapping("/song/{id}/delete")
    public String deleteSong(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        songService.deleteSong(id);
        return "success!";
    }
    @GetMapping("/song/{id}/getAlternativeTitles")
    public List<String> getAlternativeTitlesForASong(@PathVariable Integer id){
        return alternativeTitlesService.getAlternativeTitlesForSong(id);
    }
    @PostMapping("/song/addAlternativeTitle")
    public String addAlternativeTitle(@RequestBody @Valid AlternativeTitlesDTO alternativeTitle){
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        alternativeTitlesService.createAlternativeTitle(alternativeTitle);
        return "success!";
    }


}
