package com.example.musify.repo;

import com.example.musify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepositoryJPA extends JpaRepository<Song,Integer> {
}
