package com.example.musify.repo;

import com.example.musify.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepositoryJPA extends JpaRepository<Album,Integer> {
    Optional<Album> findById(Integer id);

}