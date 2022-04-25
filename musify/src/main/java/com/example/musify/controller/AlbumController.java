package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.exception.AlreadyExistingDataException;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.exception.WrongInputException;
import com.example.musify.model.Album;
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
        } catch (DataNotFoundException | WrongInputException e) {
            return e.getLocalizedMessage();
        }

    }

    @PutMapping("/album/update")
    public String updateAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        try {
            albumService.updateAlbum(albumDTO);
            return "success!";
        } catch (DataNotFoundException e) {
            return e.getLocalizedMessage();
        }
    }

    @DeleteMapping("/album/delete/{id}")
    public String deleteAlbum(@PathVariable Integer id) {
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setId(id);
        albumService.deleteAlbum(albumDTO);
        return "success!";
    }

    @GetMapping("/album/get_songs/{id}")
    public ResponseEntity<List<SongDTO>> getAlbumSongs(@PathVariable Integer id) {
        List<SongDTO> songs = albumService.getAlbumSongs(id);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping("/album/add_song/{idAlbum}/{idSong}")
    public String addSongToAlbum(@PathVariable Integer idAlbum, @PathVariable Integer idSong) {
        try {
            albumService.addSongToAlbum(idAlbum, idSong);
            return "success!";
        } catch (DataNotFoundException | AlreadyExistingDataException e) {
            return e.getLocalizedMessage();
        }

    }

    @PutMapping("/album/change_songs_order/{idAlbum}/{idSong}/{newOrderNumber}")
    public String changeSongsOrder(@PathVariable Integer idAlbum, @PathVariable Integer idSong, @PathVariable Integer newOrderNumber) {
        try {
            albumService.changeSongOrderNumber(idAlbum, idSong, newOrderNumber);
            return "success!";
        } catch (DataNotFoundException | WrongInputException e) {
            return e.getLocalizedMessage();
        }
    }

    @GetMapping("/album/from_artist/{id}")
    public ResponseEntity<List<AlbumViewDTO>> getAlbumsByArtist(@PathVariable Integer id) {
        List<AlbumViewDTO> albums = albumService.getAllAlbumsByArtist(id);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/album/from_band/{id}")
    public ResponseEntity<List<AlbumViewDTO>> getAlbumsByBand(@PathVariable Integer id) {
        List<AlbumViewDTO> albums = albumService.getAllAlbumsByBand(id);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }
}
