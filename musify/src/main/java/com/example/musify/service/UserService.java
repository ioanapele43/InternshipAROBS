package com.example.musify.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    public String getMessage(){
        return "hello from user service";
    }
}
