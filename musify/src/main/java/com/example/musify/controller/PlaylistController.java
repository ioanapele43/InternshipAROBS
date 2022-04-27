package com.example.musify.controller;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.PlaylistViewDTO;
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
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.createPlaylist(playlistDTO);
        return "success!";
    }

    @PutMapping("/playlist/update")
    public String updatePlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.updatePlaylist(playlistDTO);
        return "success!";
    }

    @DeleteMapping("/playlist/delete/{id}")
    public String deletePlaylist(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        PlaylistDTO playlistDTO = new PlaylistDTO();
        playlistDTO.setId(id);
        playlistService.deletePlaylist(playlistDTO);
        return "success!";
    }
    @PostMapping("/playlist/addSong/{idPlaylist}/{idSong}")
    public String addSongToPlaylist(@PathVariable Integer idPlaylist,@PathVariable Integer idSong){
        playlistService.addSongToPlaylist(idPlaylist,idSong);
        return "Success!";
    }
    @GetMapping("/playlists/get_created_playlist")
    public List<PlaylistDTO> getPlaylistsCreated(){
        return playlistService.getPlaylistCreatedByTheCurrentUser();
    }
    @GetMapping("/playlists/get_followed_playlist")
    public List<PlaylistDTO> getPlaylistsFollowed(){
        return playlistService.getPlaylistFollowedByTheCurrentUser();
    }
    @PostMapping("/playlist/follow_playlist/{id}")
    public String followPlaylist(@PathVariable Integer id){
        playlistService.followPlaylistByCurrentUser(id);
        return "Success!";
    }
}
