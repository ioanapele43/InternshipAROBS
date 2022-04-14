package com.example.musify.service;

import com.example.musify.repo.UserRepositoryJPA;
import com.example.musify.service.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class UserService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserRepositoryJPA userRepositoryJPA;
    @Autowired
    private UserMapper userMapper;
}
