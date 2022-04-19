package com.example.musify.service;

import com.example.musify.dto.SongDTO;
import com.example.musify.model.Song;
import com.example.musify.repo.SongRepositoryJPA;
import com.example.musify.service.mappers.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SongRepositoryJPA songRepositoryJPA;
    @Autowired
    private SongMapper songMapper;
    public List<Song> getAllSongs(){
        return songRepositoryJPA.findAll();
    }
    public Song getSongById(Integer id){
        return songRepositoryJPA.getSongById(id);
    }
    @Transactional
    public void createSong(SongDTO songDTO){
        songRepositoryJPA.save(songMapper.toEntity(songDTO));
    }
    @Transactional
    public void updateSong(SongDTO songDTO){
        songRepositoryJPA.save(songMapper.toEntity(songDTO));
    }
    @Transactional
    public void deleteSong(SongDTO songDTO){
        songRepositoryJPA.delete(songMapper.toEntity(songDTO));
    }

}
