package com.example.musify.service;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.dto.PlaylistViewDTO;
import com.example.musify.model.Playlist;
import com.example.musify.repo.PlaylistRepositoryJPA;
import com.example.musify.service.mappers.PlaylistMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {
    private final PlaylistRepositoryJPA playlistRepositoryJPA;
    private final PlaylistMapper playlistMapper;

    public PlaylistService(PlaylistRepositoryJPA playlistRepositoryJPA, PlaylistMapper playlistMapper) {
        this.playlistRepositoryJPA = playlistRepositoryJPA;
        this.playlistMapper = playlistMapper;
    }

    public List<PlaylistViewDTO> getAllPlaylists() {
        return playlistRepositoryJPA.findAll().stream().map(p -> playlistMapper.toViewDto(p)).collect(Collectors.toList());
    }

    public PlaylistViewDTO getPlaylistbyId(Integer id) {
        return playlistMapper.toViewDto(playlistRepositoryJPA.getPlaylistById(id));
    }

    @Transactional
    public void createPlaylist(PlaylistDTO playlistDTO) {
        playlistRepositoryJPA.save(playlistMapper.toEntity(playlistDTO));
    }

    @Transactional
    public void updatePlaylist(PlaylistDTO playlistDTO) {
        playlistRepositoryJPA.save(playlistMapper.toEntity(playlistDTO));
    }

    @Transactional
    public void deletePlaylist(PlaylistDTO playlistDTO) {
        playlistRepositoryJPA.delete(playlistMapper.toEntity(playlistDTO));
    }

}
