package com.example.musify.service;

import com.example.musify.repo.PlaylistRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class PlaylistService {
   @Autowired
    private DataSource dataSource;
   @Autowired
    private PlaylistRepositoryJPA playlistRepositoryJPA;
}
