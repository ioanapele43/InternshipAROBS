package com.example.musify.controller;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/Playlist")
    public List<PlaylistViewDTO> getAllPlaylists() {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/Playlist/{idPlaylist}")
    public PlaylistViewDTO getPlaylistById(@PathVariable Integer idPlaylist) {
        return playlistService.getPlaylistbyId(idPlaylist);
    }

    @PostMapping("/Playlist")
    public PlaylistViewDTO createPlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
        return playlistService.createPlaylist(playlistDTO);
    }

    @PutMapping("/Playlist/{idPlaylist}")
    public PlaylistViewDTO updatePlaylist(@PathVariable Integer idPlaylist, @RequestBody @Valid PlaylistDTO playlistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return playlistService.updatePlaylist(idPlaylist, playlistDTO);
    }

    @DeleteMapping("/Playlist/{idPlaylist}")
    public void deletePlaylist(@PathVariable Integer idPlaylist) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.deletePlaylist(idPlaylist);
    }

    @PostMapping("/Playlist/{idPlaylist}/Song/{idSong}")
    public List<SongViewDTO> addSongToPlaylist(@PathVariable Integer idPlaylist, @PathVariable Integer idSong) {
        return playlistService.addSongToPlaylist(idPlaylist, idSong);
    }


    @PostMapping("/Playlist/{id}/Follow")
    public List<PlaylistViewDTO> followPlaylist(@PathVariable Integer id) {
        return playlistService.followPlaylistByCurrentUser(id);
    }

    @PostMapping("/Playlist/{id}/Unfollow")
    public List<PlaylistViewDTO> unfollowPlaylist(@PathVariable Integer id) {
        return playlistService.unfollowPlaylistByCurrentUser(id);
    }

    @PostMapping("/Playlist/{idPlaylist}/Album/{idAlbum}")
    public List<SongViewDTO> addSongFromAnAlbum(@PathVariable Integer idPlaylist, @PathVariable Integer idAlbum) {
        return playlistService.addAlbumSongsToPlaylist(idPlaylist, idAlbum);
    }

    @PutMapping("/Playlist/{idPlaylist}/{idSong}/{newOrderNumber}")
    public List<SongViewDTO> changeSongsOrder(@PathVariable Integer idPlaylist, @PathVariable Integer idSong, @PathVariable Integer newOrderNumber) {
        return playlistService.changeSongOrderNumber(idPlaylist, idSong, newOrderNumber);
    }

    @GetMapping("/Playlist/{idPlaylist}/Songs")
    public List<SongViewDTO> getPlaylistSongs(@PathVariable Integer idPlaylist) {
        return playlistService.getPlaylistSongs(idPlaylist);
    }
}
