package com.example.musify.service;

import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.dto.SongViewDTO;
import com.example.musify.model.Song;
import com.example.musify.repo.AlternativeTitlesRepositoryJPA;
import com.example.musify.service.mappers.AlternativeTitlesMapper;
import com.example.musify.service.mappers.SongMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlternativeTitlesService {
    private final AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA;
    private final AlternativeTitlesMapper alternativeTitlesMapper;
    private final SongMapper songMapper;


    public AlternativeTitlesService(AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA, AlternativeTitlesMapper alternativeTitlesMapper, SongMapper songMapper) {
        this.alternativeTitlesRepositoryJPA = alternativeTitlesRepositoryJPA;
        this.alternativeTitlesMapper = alternativeTitlesMapper;
        this.songMapper = songMapper;
    }

    public List<SongViewDTO> getAllAternativeTitles() {
        return alternativeTitlesRepositoryJPA.findAll().stream().map(s->songMapper.toViewDto(s)).collect(Collectors.toList());
    }

    public SongViewDTO getAlternativeTitleById(Integer id) {
        return songMapper.toViewDto(alternativeTitlesRepositoryJPA.findById(id));
    }

    @Transactional
    public void createAlternativeTitle(AlternativeTitlesDTO alternativeTitlesDTO) {
        alternativeTitlesRepositoryJPA.save(alternativeTitlesMapper.toEntity(alternativeTitlesDTO));
    }

    @Transactional
    public void updateAlternativeTitle(AlternativeTitlesDTO alternativeTitlesDTO) {
        alternativeTitlesRepositoryJPA.save(alternativeTitlesMapper.toEntity(alternativeTitlesDTO));
    }

    @Transactional
    public void deleteAlternativeTitle(AlternativeTitlesDTO alternativeTitlesDTO) {
        alternativeTitlesRepositoryJPA.delete(alternativeTitlesMapper.toEntity(alternativeTitlesDTO));
    }

}
