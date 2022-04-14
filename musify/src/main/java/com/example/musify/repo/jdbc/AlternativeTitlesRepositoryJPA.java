package com.example.musify.repo.jdbc;

import com.example.musify.model.AlternativeTitles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativeTitlesRepositoryJPA extends JpaRepository<AlternativeTitles,Integer> {
}
