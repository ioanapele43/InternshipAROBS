package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongViewDTO {
    private String title;
    private Time duration;
    private Date creationDate;
}
