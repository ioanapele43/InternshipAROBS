package com.example.musify.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserViewDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
