package com.example.musify.repo;

import com.example.musify.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaylistRepositoryJPA extends JpaRepository<Playlist,Integer> {
    Playlist getPlaylistById(Integer id);
}
