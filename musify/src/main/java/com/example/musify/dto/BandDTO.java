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
public class BandDTO {

    @NotBlank(message = "Band name cannot be blank!")
    private String bandname;
    @NotBlank(message = "Location cannot be blank!")
    private String location;
    @NotBlank(message = "Activity start date cannot be blank!")
    private Date activityStartDate;
    @NotBlank(message = "Activity end date cannot be blank!")
    private Date activityEndDate;

}
