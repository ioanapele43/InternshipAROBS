package com.example.musify.service;

import com.example.musify.repo.SongRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class SongService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private SongRepositoryJPA songRepositoryJPA;

}
