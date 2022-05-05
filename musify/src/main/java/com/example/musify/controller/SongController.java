package com.example.musify.controller;


import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.AlternativeTitlesService;
import com.example.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    private AlternativeTitlesService alternativeTitlesService;


    @GetMapping("/Song")
    public List<SongViewDTO> getAllPlaylists() {
        return songService.getAllSongs();
    }

    @GetMapping("/Song/{idSong}")
    public SongViewDTO getPlaylistById(@PathVariable Integer idSong) {
        return songService.getSongById(idSong);
    }

    @PostMapping("/Song")
    public SongViewDTO createSong(@RequestBody @Valid SongDTO songDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return songService.createSong(songDTO);
    }

    @PutMapping("/Song/{idSong}")
    public SongViewDTO updateSong(@PathVariable Integer idSong, @RequestBody @Valid SongDTO songDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return songService.updateSong(idSong, songDTO);
    }

    @DeleteMapping("/Song/{idSong}")
    public void deleteSong(@PathVariable Integer idSong) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        songService.deleteSong(idSong);
    }

    @GetMapping("/Song/{idSong}/AlternativeTitles")
    public List<String> getAlternativeTitlesForASong(@PathVariable Integer id) {
        return alternativeTitlesService.getAlternativeTitlesForSong(id);
    }

    @PostMapping("/Song/AlternativeTitle")
    public AlternativeTitlesDTO addAlternativeTitle(@RequestBody @Valid AlternativeTitlesDTO alternativeTitle) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return alternativeTitlesService.createAlternativeTitle(alternativeTitle);
    }

    @GetMapping("Songs/AlternativeTitles")
    public List<AlternativeTitlesDTO> getAllAlternativeTitles() {
        return alternativeTitlesService.getAllAternativeTitles();
    }


}
