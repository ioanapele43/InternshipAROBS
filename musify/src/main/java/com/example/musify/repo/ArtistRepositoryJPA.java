package com.example.musify.repo;

import com.example.musify.model.Artist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepositoryJPA extends JpaRepository<Artist,Integer> {
    Optional<Artist> findByFirstname(String firstname);
    Optional<Artist> findById(Integer id);
    //search for artist by firstname or lastname
    Optional<List<Artist>> findArtistsByFirstname(String firstname);
    List<Artist> getArtistsByLastnameContainingIgnoreCase(String lastname);
}
