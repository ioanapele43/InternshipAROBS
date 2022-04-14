package com.example.musify.service;

import com.example.musify.repo.AlbumRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class AlbumService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private AlbumRepositoryJPA albumRepositoryJPA;
}
