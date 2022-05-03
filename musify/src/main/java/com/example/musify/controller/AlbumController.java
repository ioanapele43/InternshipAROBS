package com.example.musify.controller;

import com.example.musify.dto.AlbumDTO;
import com.example.musify.dto.AlbumViewDTO;
import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/Album")
    public ResponseEntity<List<AlbumViewDTO>> getAllAlbums() {
        List<AlbumViewDTO> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/Album/{idAlbum}")
    public ResponseEntity<AlbumViewDTO> getAlbumById(Integer idAlbum) {
        AlbumViewDTO album = albumService.getAlbumById(idAlbum);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping("/Album")
    public AlbumViewDTO createAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return albumService.createAlbum(albumDTO);
    }

    @PutMapping("/Album/{idAlbum}")
    public AlbumViewDTO updateAlbum(@PathVariable Integer idAlbum, @RequestBody @Valid AlbumDTO albumDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return albumService.updateAlbum(idAlbum, albumDTO);
    }

    @DeleteMapping("/Album/{idAlbum}")
    public void deleteAlbum(@PathVariable Integer idAlbum) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        albumService.deleteAlbum(idAlbum);
    }

    @GetMapping("/Album/{idAlbum}/songs")
    public List<SongDTO> getAlbumSongs(@PathVariable Integer idAlbum) {
        return albumService.getAlbumSongs(idAlbum);
    }

    @PostMapping("/Album/{idAlbum}/{idSong}")
    public List<SongViewDTO> addSongToAlbum(@PathVariable Integer idAlbum, @PathVariable Integer idSong) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return albumService.addSongToAlbum(idAlbum, idSong);

    }

    @PutMapping("/Album/{idAlbum}/{idSong}/{newOrderNumber}")
    public List<SongViewDTO> changeSongsOrder(@PathVariable Integer idAlbum, @PathVariable Integer idSong, @PathVariable Integer newOrderNumber) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return albumService.changeSongOrderNumber(idAlbum, idSong, newOrderNumber);
    }

    @GetMapping("/Album/{idArtist}")
    public List<AlbumViewDTO> getAlbumsByArtist(@PathVariable Integer idArtist) {
        return albumService.getAllAlbumsByArtist(idArtist);
    }

    @GetMapping("/Album/{idBand}")
    public List<AlbumViewDTO> getAlbumsByBand(@PathVariable Integer idBand) {
        return albumService.getAllAlbumsByBand(idBand);
    }
}
