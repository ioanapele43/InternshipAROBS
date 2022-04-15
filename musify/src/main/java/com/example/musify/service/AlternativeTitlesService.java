package com.example.musify.service;

import com.example.musify.dto.AlternativeTitlesDTO;
import com.example.musify.model.Song;
import com.example.musify.repo.AlternativeTitlesRepositoryJPA;
import com.example.musify.service.mappers.AlternativeTitlesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AlternativeTitlesService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA;
    @Autowired
    private AlternativeTitlesMapper alternativeTitlesMapper;

    public List<Song> getAllAternativeTitles(){
        return alternativeTitlesRepositoryJPA.findAll();
    }
    public Optional<Song> getAlternativeTitleById(Integer id){
        return alternativeTitlesRepositoryJPA.findById(id);
    }
    @Transactional
    public void createAlternativeTitle(AlternativeTitlesDTO alternativeTitlesDTO){
        alternativeTitlesRepositoryJPA.save(alternativeTitlesMapper.toEntity(alternativeTitlesDTO));
    }
    @Transactional
    public void updateAlternativeTitle(AlternativeTitlesDTO alternativeTitlesDTO){
        alternativeTitlesRepositoryJPA.save(alternativeTitlesMapper.toEntity(alternativeTitlesDTO));
    }
    @Transactional
    public void deleteAlternativeTitle(AlternativeTitlesDTO alternativeTitlesDTO){
        alternativeTitlesRepositoryJPA.delete(alternativeTitlesMapper.toEntity(alternativeTitlesDTO));
    }

}
