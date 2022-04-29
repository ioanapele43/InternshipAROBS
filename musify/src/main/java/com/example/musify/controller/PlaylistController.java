package com.example.musify.controller;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.exception.DataNotFoundException;
import com.example.musify.exception.WrongInputException;
import com.example.musify.repo.jdbc.PlaylistRepository;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private DataSource dataSource;

    @GetMapping("/playlists")
    public ResponseEntity<List<PlaylistViewDTO>> getAllPlaylists() {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        List<PlaylistViewDTO> playlist = playlistService.getAllPlaylists();
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @GetMapping("/playlist/{id}")
    public ResponseEntity<PlaylistViewDTO> getPlaylistById(Integer id) {
        PlaylistViewDTO playlist = playlistService.getPlaylistbyId(id);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @PostMapping("/playlist/create")
    public String createPlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
       // AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.createPlaylist(playlistDTO);
        return "success!";
    }

    @PutMapping("/playlist/{id}/update")
    public String updatePlaylist(@PathVariable Integer id, @RequestBody @Valid PlaylistDTO playlistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.updatePlaylist(id, playlistDTO);
        return "success!";
    }

    @DeleteMapping("/playlist/{id}/delete")
    public String deletePlaylist(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.deletePlaylist(id);
        return "success!";
    }

    @PostMapping("/playlist/{idPlaylist}/addSong/{idSong}")
    public String addSongToPlaylist(@PathVariable Integer idPlaylist, @PathVariable Integer idSong) {
        playlistService.addSongToPlaylist(idPlaylist, idSong);
        return "Success!";
    }

    @GetMapping("/playlists/get_created_playlists")
    public List<PlaylistViewDTO> getPlaylistsCreated() {
        return playlistService.getPlaylistCreatedByTheCurrentUser();
    }

    @GetMapping("/playlists/get_followed_playlists")
    public List<PlaylistViewDTO> getPlaylistsFollowed() {
        return playlistService.getPlaylistFollowedByTheCurrentUser();
    }

    @PostMapping("/playlist/{id}/follow_playlist")
    public String followPlaylist(@PathVariable Integer id) {
        playlistService.followPlaylistByCurrentUser(id);
        return "Success!";
    }

    @PostMapping("/playlist/{idPlaylist}/add_aongs_from_album/{idAlbum}")
    public String addSongFromAnAlbum(@PathVariable Integer idPlaylist, @PathVariable Integer idAlbum) {
        playlistService.addAlbumSongsToPlaylist(idPlaylist, idAlbum);
        return "success!";
    }

    @PutMapping("/playlist/{idPlaylist}/change_songs_order/{idSong}/{newOrderNumber}")
    public String changeSongsOrder(@PathVariable Integer idPlaylist, @PathVariable Integer idSong, @PathVariable Integer newOrderNumber) {
        //AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.changeSongOrderNumber(idPlaylist, idSong, newOrderNumber);
        return "success!";
    }
}
