package com.example.musify.repo;

import com.example.musify.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BandRepositoryJPA extends JpaRepository<Band,Integer> {
   Band getBandById(Integer id);

}
