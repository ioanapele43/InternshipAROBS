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
    public AlbumViewDTO createAlbum(@RequestBody @Valid AlbumDTO albumDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return albumService.createAlbum(albumDTO);
    }

    @PutMapping("/album/{id}/update")
    public AlbumViewDTO updateAlbum(@PathVariable Integer id, @RequestBody @Valid AlbumDTO albumDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return albumService.updateAlbum(id, albumDTO);
    }

    @DeleteMapping("/album/{id}/delete")
    public void deleteAlbum(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        albumService.deleteAlbum(id);
    }

    @GetMapping("/album/{id}/get_songs")
    public List<SongDTO> getAlbumSongs(@PathVariable Integer id) {
        return albumService.getAlbumSongs(id);
    }

    @PostMapping("/album/{idAlbum}/add_song/{idSong}")
    public List<SongViewDTO> addSongToAlbum(@PathVariable Integer idAlbum, @PathVariable Integer idSong) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return albumService.addSongToAlbum(idAlbum, idSong);

    }

    @PutMapping("/album/{idAlbum}/change_songs_order/{idSong}/{newOrderNumber}")
    public List<SongViewDTO> changeSongsOrder(@PathVariable Integer idAlbum, @PathVariable Integer idSong, @PathVariable Integer newOrderNumber) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return albumService.changeSongOrderNumber(idAlbum, idSong, newOrderNumber);
    }

    @GetMapping("/albums/from_artist/{idArtist}")
    public List<AlbumViewDTO> getAlbumsByArtist(@PathVariable Integer idArtist) {
        return albumService.getAllAlbumsByArtist(idArtist);
    }

    @GetMapping("/albums/from_band/{idBand}")
    public List<AlbumViewDTO> getAlbumsByBand(@PathVariable Integer idBand) {
        return albumService.getAllAlbumsByBand(idBand);
    }
}
