package com.example.musify.service;

import com.example.musify.repo.BandRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class BandService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private BandRepositoryJPA bandRepositoryJPA;
}
