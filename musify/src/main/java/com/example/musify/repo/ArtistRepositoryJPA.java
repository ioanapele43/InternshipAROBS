package com.example.musify.repo;

import com.example.musify.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepositoryJPA extends JpaRepository<Artist,Integer> {
    Optional<Artist> findByFirstname(String firstname);
    Optional<Artist> findById(Integer id);
}
