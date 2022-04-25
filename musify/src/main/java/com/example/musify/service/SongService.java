package com.example.musify.service;

import com.example.musify.dto.SongDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.model.Song;
import com.example.musify.repo.SongRepositoryJPA;
import com.example.musify.service.mappers.SongMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {
    private final SongRepositoryJPA songRepositoryJPA;
    private final SongMapper songMapper;

    public SongService(SongRepositoryJPA songRepositoryJPA, SongMapper songMapper) {
        this.songRepositoryJPA = songRepositoryJPA;
        this.songMapper = songMapper;
    }

    public List<SongViewDTO> getAllSongs() {
        return songRepositoryJPA.findAll().stream().map(s -> songMapper.toViewDto(s)).collect(Collectors.toList());
    }

    public SongViewDTO getSongById(Integer id) {
        return songMapper.toViewDto(songRepositoryJPA.getSongById(id));
    }

    @Transactional
    public void createSong(SongDTO songDTO) {
        songRepositoryJPA.save(songMapper.toEntity(songDTO));
    }

    @Transactional
    public void updateSong(SongDTO songDTO) {
        songRepositoryJPA.save(songMapper.toEntity(songDTO));
    }

    @Transactional
    public void deleteSong(SongDTO songDTO) {
        songRepositoryJPA.delete(songMapper.toEntity(songDTO));
    }

}
