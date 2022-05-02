package com.example.musify.controller;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.repo.jdbc.PlaylistRepository;
import com.example.musify.security.AdminVerify;
import com.example.musify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<PlaylistViewDTO> getAllPlaylists() {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/playlist/{id}")
    public PlaylistViewDTO getPlaylistById(Integer id) {
        return playlistService.getPlaylistbyId(id);
    }

    @PostMapping("/playlist/create")
    public PlaylistViewDTO createPlaylist(@RequestBody @Valid PlaylistDTO playlistDTO) {
        return playlistService.createPlaylist(playlistDTO);
    }

    @PutMapping("/playlist/{id}/update")
    public PlaylistViewDTO updatePlaylist(@PathVariable Integer id, @RequestBody @Valid PlaylistDTO playlistDTO) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        return playlistService.updatePlaylist(id, playlistDTO);
    }

    @DeleteMapping("/playlist/{id}/delete")
    public void deletePlaylist(@PathVariable Integer id) {
        AdminVerify.checkIfTheUserLoggedIsAdmin();
        playlistService.deletePlaylist(id);
    }

    @PostMapping("/playlist/{idPlaylist}/addSong/{idSong}")
    public List<SongViewDTO> addSongToPlaylist(@PathVariable Integer idPlaylist, @PathVariable Integer idSong) {
        return playlistService.addSongToPlaylist(idPlaylist, idSong);
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
    public List<PlaylistViewDTO> followPlaylist(@PathVariable Integer id) {
        return playlistService.followPlaylistByCurrentUser(id);
    }

    @PostMapping("/playlist/{id}/unfollow_playlist")
    public List<PlaylistViewDTO> unfollowPlaylist(@PathVariable Integer id) {
        return playlistService.unfollowPlaylistByCurrentUser(id);
    }

    @PostMapping("/playlist/{idPlaylist}/add_songs_from_album/{idAlbum}")
    public List<SongViewDTO> addSongFromAnAlbum(@PathVariable Integer idPlaylist, @PathVariable Integer idAlbum) {
        return playlistService.addAlbumSongsToPlaylist(idPlaylist, idAlbum);
    }

    @PutMapping("/playlist/{idPlaylist}/change_songs_order/{idSong}/{newOrderNumber}")
    public List<SongViewDTO> changeSongsOrder(@PathVariable Integer idPlaylist, @PathVariable Integer idSong, @PathVariable Integer newOrderNumber) {
        return playlistService.changeSongOrderNumber(idPlaylist, idSong, newOrderNumber);
    }
}
