package com.example.musify.controller;

import com.example.musify.repo.ArtistRepository;
import com.example.musify.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;

@RestController
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private ArtistService artistService;
    @Autowired
    private DataSource dataSource;
}
