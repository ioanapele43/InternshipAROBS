package com.example.musify.repo;

import com.example.musify.model.AlternativeTitles;
import com.example.musify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlternativeTitlesRepositoryJPA extends JpaRepository<AlternativeTitles, Integer> {
    AlternativeTitles getAlternativeTitlesById(Integer id);
    List<AlternativeTitles> getAlternativeTitlesBySongId(Integer id);
    
}
