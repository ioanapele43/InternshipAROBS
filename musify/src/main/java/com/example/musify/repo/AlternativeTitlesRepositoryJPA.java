package com.example.musify.repo;

import com.example.musify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlternativeTitlesRepositoryJPA extends JpaRepository<Song, Integer> {
    Optional<Song> findById(Integer id);
}
