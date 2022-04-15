package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SongDTO {
    @NotNull
    private Integer id;
    @NotBlank(message = "Title cannot be blank!")
    private String title;
    @NotBlank(message = "Duration cannot be blank!")
    private Time duration;
    @NotBlank(message = "Creation Date cannot be blank!")
    private Date creationDate;
}
