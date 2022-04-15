package com.example.musify.service;

import com.example.musify.dto.PlaylistDTO;
import com.example.musify.model.Playlist;
import com.example.musify.repo.PlaylistRepositoryJPA;
import com.example.musify.service.mappers.PlaylistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
   @Autowired
    private DataSource dataSource;
   @Autowired
    private PlaylistRepositoryJPA playlistRepositoryJPA;
   @Autowired
    private PlaylistMapper playlistMapper;

   public List<Playlist> getAllPlaylists(){
       return playlistRepositoryJPA.findAll();
   }
   public Optional<Playlist> getPlaylistbyId(Integer id){
       return  playlistRepositoryJPA.findById(id);
   }
   @Transactional
    public void createPlaylist(PlaylistDTO playlistDTO){
       playlistRepositoryJPA.save(playlistMapper.toEntity(playlistDTO));
   }
    @Transactional
    public void updatePlaylist(PlaylistDTO playlistDTO){
        playlistRepositoryJPA.save(playlistMapper.toEntity(playlistDTO));
    }
    @Transactional
    public void deletePlaylist(PlaylistDTO playlistDTO){
        playlistRepositoryJPA.delete(playlistMapper.toEntity(playlistDTO));
    }

}
