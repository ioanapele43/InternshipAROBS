package com.example.musify.controller;


import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.repo.jdbc.SongRepositoty;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.AlternativeTitlesService;
import com.example.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<SongViewDTO> getAllPlaylists() {
        return songService.getAllSongs();
    }

    @GetMapping("/song/{id}")
    public SongViewDTO getPlaylistById(Integer id) {
        return songService.getSongById(id);
    }

    @PostMapping("/song/create")
    public SongViewDTO createSong(@RequestBody @Valid SongDTO songDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return songService.createSong(songDTO);
    }

    @PutMapping("/song/{id}/update")
    public SongViewDTO updateSong(@PathVariable Integer id, @RequestBody @Valid SongDTO songDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return songService.updateSong(id, songDTO);
    }

    @DeleteMapping("/song/{id}/delete")
    public void deleteSong(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        songService.deleteSong(id);
    }

    @GetMapping("/song/{id}/getAlternativeTitles")
    public List<String> getAlternativeTitlesForASong(@PathVariable Integer id) {
        return alternativeTitlesService.getAlternativeTitlesForSong(id);
    }

    @PostMapping("/song/addAlternativeTitle")
    public AlternativeTitlesDTO addAlternativeTitle(@RequestBody @Valid AlternativeTitlesDTO alternativeTitle) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return alternativeTitlesService.createAlternativeTitle(alternativeTitle);
    }

    @GetMapping("songs/get_all_alternative_titles")
    public List<AlternativeTitlesDTO> getAllAlternativeTitles() {
        return alternativeTitlesService.getAllAternativeTitles();
    }


}
