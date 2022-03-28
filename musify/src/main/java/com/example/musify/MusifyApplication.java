package com.example.musify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.musify")
public class MusifyApplication {

	public static void main(String[] args) {SpringApplication.run(MusifyApplication.class, args);
	}

}
