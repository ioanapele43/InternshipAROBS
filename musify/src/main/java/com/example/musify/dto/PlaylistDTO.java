package com.example.musify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaylistDTO {
    @NotNull
    private Integer id;
    @NotBlank(message = "Type cannot be blank!")
    private String type;
    @NotBlank(message = "Creation date cannot be blank!")
    private Date createdDate;
    @NotBlank(message = "Last update date cannot be blank!")
    private Date lastUpdatedate;
}
