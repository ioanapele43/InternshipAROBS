package com.example.musify.controller;

import com.example.musify.repo.jdbc.SongRepositoty;
import com.example.musify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class SongController {
    @Autowired
    private SongRepositoty songRepositoty;
    @Autowired
    private SongService songService;
    @Autowired
    private DataSource dataSource;


}
