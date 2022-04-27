package com.example.musify.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ArtistDTO {

    @NotBlank(message = "First name cannot be blank!")
    private String firstname;
    @NotBlank(message = "Last name cannot be blank!")
    private String lastname;
    @NotBlank(message = "Stage name cannot be blank!")
    private String stagename;
    @NotBlank(message = "Birthday cannot be blank!")
    private Date birthday;
    @NotBlank(message = "Activity start date cannot be blank!")
    private Date activityStartDate;
    @NotBlank(message = "Activity end date cannot be blank!")
    private Date activityEndDate;
}
