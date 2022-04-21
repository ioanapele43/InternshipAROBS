package com.example.musify.repo;

import com.example.musify.model.Artist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepositoryJPA extends JpaRepository<Artist, Integer> {
    Optional<Artist> findByFirstname(String firstname);

    Optional<Artist> findById(Integer id);

    //search for artist by firstname or lastname
    @Query("SELECT a FROM Artist a WHERE a.firstname LIKE :name ")
    List<Artist> findArtistByFirstname(@Param("name") String name);

    @Query("SELECT a FROM Artist a WHERE  a.lastname LIKE :name")
    List<Artist> findArtistByLastname(@Param("name") String name);

    @Query("SELECT a FROM Artist a WHERE a.firstname LIKE :name OR a.lastname LIKE :name")
    List<Artist> findArtistByFirstnameOrLastname(@Param("name") String name);
}
