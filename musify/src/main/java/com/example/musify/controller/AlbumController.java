package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.exception.AlreadyExistingDataException;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.exception.WrongInputException;
import com.example.musify.security.AdminVerify;
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
    public ResponseEntity<AlbumViewDTO> getAlbumById(Integer id) {
        AlbumViewDTO album = albumService.getAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping("/album/create")
    public String createAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        try {
            albumService.createAlbum(albumDTO);
            return "success!";
        } catch (DataNotFoundException | WrongInputException e) {
            return e.getLocalizedMessage();
        }

    }

    @PutMapping("/album/{id}/update")
    public String updateAlbum(@PathVariable Integer id,@RequestBody @Valid AlbumDTO albumDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        try {
            albumService.updateAlbum(id,albumDTO);
            return "success!";
        } catch (DataNotFoundException e) {
            return e.getLocalizedMessage();
        }
    }

    @DeleteMapping("/album/{id}/delete")
    public String deleteAlbum(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        albumService.deleteAlbum(id);
        return "success!";
    }

    @GetMapping("/album/{id}/get_songs")
    public ResponseEntity<List<SongDTO>> getAlbumSongs(@PathVariable Integer id) {
        List<SongDTO> songs = albumService.getAlbumSongs(id);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping("/album/{idAlbum}/add_song/{idSong}")
    public String addSongToAlbum(@PathVariable Integer idAlbum, @PathVariable Integer idSong) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        try {
            albumService.addSongToAlbum(idAlbum, idSong);
            return "success!";
        } catch (DataNotFoundException | AlreadyExistingDataException e) {
            return e.getLocalizedMessage();
        }

    }

    @PutMapping("/album/{idAlbum}/change_songs_order/{idSong}/{newOrderNumber}")
    public String changeSongsOrder(@PathVariable Integer idAlbum, @PathVariable Integer idSong, @PathVariable Integer newOrderNumber) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        try {
            albumService.changeSongOrderNumber(idAlbum, idSong, newOrderNumber);
            return "success!";
        } catch (DataNotFoundException | WrongInputException e) {
            return e.getLocalizedMessage();
        }
    }

    @GetMapping("/albums/from_artist/{idArtist}")
    public ResponseEntity<List<AlbumViewDTO>> getAlbumsByArtist(@PathVariable Integer idArtist) {
        List<AlbumViewDTO> albums = albumService.getAllAlbumsByArtist(idArtist);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/albums/from_band/{idBand}")
    public ResponseEntity<List<AlbumViewDTO>> getAlbumsByBand(@PathVariable Integer idBand) {
        List<AlbumViewDTO> albums = albumService.getAllAlbumsByBand(idBand);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }
}
