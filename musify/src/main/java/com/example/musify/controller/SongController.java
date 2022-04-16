package com.example.musify.controller;


import com.example.musify.dto.SongDTO;
import com.example.musify.model.Song;
import com.example.musify.repo.jdbc.SongRepositoty;
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
    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllPlaylists(){
        List<Song> song=songService.getAllSongs();
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
    @GetMapping("/song/{id}")
    public ResponseEntity<Song> getPlaylistById(Integer id){
        Song song=songService.getSongById(id);
        return new ResponseEntity<>(song,HttpStatus.OK);
    }
    @PostMapping("/song/create")
    public String createSong(@RequestBody @Valid SongDTO songDTO){
        songService.createSong(songDTO);
        return "success!";
    }
    @PutMapping("/song/update")
    public String updateSong(@RequestBody @Valid SongDTO songDTO){
        songService.updateSong(songDTO);
        return "success!";
    }
    @DeleteMapping("/song/delete")
    public String deleteSong(@RequestBody @Valid SongDTO songDTO){
        songService.deleteSong(songDTO);
        return "success!";
    }


}
