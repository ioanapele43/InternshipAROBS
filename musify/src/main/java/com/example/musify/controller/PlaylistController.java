package com.example.musify.controller;

import com.example.musify.repo.jdbc.PlaylistRepository;
import com.example.musify.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private DataSource dataSource;
}
