package com.example.musify.controller;

import com.example.musify.repo.AlbumRepository;
import com.example.musify.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private DataSource dataSource;
}
