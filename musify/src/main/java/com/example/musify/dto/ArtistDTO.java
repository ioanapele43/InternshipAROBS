package com.example.musify.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArtistDTO {
    @NotNull
    private Integer id;
    @NotBlank(message = "First name cannot be blank!")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank!")
    private String lastName;
    @NotBlank(message = "Stage name cannot be blank!")
    private String stageName;
    @NotBlank(message = "Birthday cannot be blank!")
    private Date birthday;
    @NotBlank(message = "Activity start date cannot be blank!")
    private Date activityStartDate;
    @NotBlank(message = "Activity end date cannot be blank!")
    private Date activityEndDate;
}
