package com.example.musify.service;

import com.example.musify.repo.jdbc.AlternativeTitlesRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class AlternativeTitlesService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AlternativeTitlesRepositoryJPA alternativeTitlesRepositoryJPA;
}
