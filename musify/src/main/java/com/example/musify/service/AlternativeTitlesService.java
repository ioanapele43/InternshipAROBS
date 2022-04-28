package com.example.musify.service;

import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.model.AlternativeTitles;
import com.example.musify.repo.AlternativeTitlesRepositoryJPA;
import com.example.musify.repo.SongRepositoryJPA;
import com.example.musify.service.mappers.AlternativeTitlesMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlternativeTitlesService {
    private final AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA;
    private final AlternativeTitlesMapper alternativeTitlesMapper;
    private final SongRepositoryJPA songRepositoryJPA;
    private final ValidationsService validationsService;


    public AlternativeTitlesService(AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA, AlternativeTitlesMapper alternativeTitlesMapper, SongRepositoryJPA songRepositoryJPA, ValidationsService validationsService) {
        this.alternativeTitlesRepositoryJPA = alternativeTitlesRepositoryJPA;
        this.alternativeTitlesMapper = alternativeTitlesMapper;
        this.songRepositoryJPA = songRepositoryJPA;
        this.validationsService = validationsService;
    }

    public List<AlternativeTitlesDTO> getAllAternativeTitles() {
        return alternativeTitlesRepositoryJPA.findAll().stream().map(a -> alternativeTitlesMapper.toDto(a)).collect(Collectors.toList());
    }

    public AlternativeTitlesDTO getAlternativeTitleById(Integer id) {
        return alternativeTitlesMapper.toDto(alternativeTitlesRepositoryJPA.getAlternativeTitlesById(id));
    }

    @Transactional
    public void createAlternativeTitle(AlternativeTitlesDTO alternativeTitlesDTO) {
        validationsService.checkIfASongAlreadyHasAnAlternativeTitle(alternativeTitlesDTO.getIdSong(),alternativeTitlesDTO.getAlternativeTitle());
        AlternativeTitles alternativeTitle=alternativeTitlesMapper.toEntity(alternativeTitlesDTO);
        alternativeTitle.setSong(songRepositoryJPA.getSongById(alternativeTitlesDTO.getIdSong()));
        alternativeTitlesRepositoryJPA.save(alternativeTitle);
    }

    @Transactional
    public void updateAlternativeTitle(Integer id,AlternativeTitlesDTO alternativeTitlesDTO) {
        validationsService.checkIfAnAlternativeTitleExists(id);
        AlternativeTitles alternativeTitle=alternativeTitlesMapper.toEntity(alternativeTitlesDTO);
        alternativeTitle.setId(id);
        alternativeTitlesRepositoryJPA.save(alternativeTitle);
    }

    @Transactional
    public void deleteAlternativeTitle(Integer id) {
        validationsService.checkIfAnAlternativeTitleExists(id);
        AlternativeTitles alternativeTitle=alternativeTitlesRepositoryJPA.getAlternativeTitlesById(id);
        alternativeTitlesRepositoryJPA.delete(alternativeTitle);
    }
    @Transactional
    public List<String> getAlternativeTitlesForSong(Integer idSong){
       return alternativeTitlesRepositoryJPA.getAlternativeTitlesBySong_Id(idSong).stream().map(alternativeTitle->alternativeTitle.getAlternativeTitle()).collect(Collectors.toList());
    }

}
