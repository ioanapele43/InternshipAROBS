package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.model.Album;
import com.example.musify.model.Song;
import com.example.musify.repo.AlbumRepositoryJPA;
import com.example.musify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    private AlbumRepositoryJPA albumRepositoryJPA;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private DataSource dataSource;


    @GetMapping("/albums")
    public ResponseEntity<List<AlbumViewDTO>> getAllAlbums() {
        List<AlbumViewDTO> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<Album> getAlbumById(Integer id) {
        Album album = albumService.getAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping("/album/create")
    public String createAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        try {
            albumService.createAlbum(albumDTO);
            return "success!";
        }
        catch(DataNotFoundException e){
            return e.getLocalizedMessage();
        }

    }

    @PutMapping("/album/update")
    public String updateAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        albumService.updateAlbum(albumDTO);
        return "success!";
    }

    @DeleteMapping("/album/delete/{id}")
    public String deleteAlbum(@PathVariable Integer id) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(id);
        albumService.deleteAlbum(albumDTO);
        return "success!";
    }
    @GetMapping("/album/get_songs/{id}")
    public ResponseEntity<List<SongDTO>> getAlbumSongs(@PathVariable Integer id){
        List<SongDTO> songs=albumService.getAlbumSongs(id);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @PostMapping("/album/add_song/{idAlbum}/{idSong}")
    public String addSongToAlbum(@PathVariable Integer idAlbum,@PathVariable Integer idSong){
        albumService.addSongToAlbum(idAlbum,idSong);
        return "Success!";
    }
}
