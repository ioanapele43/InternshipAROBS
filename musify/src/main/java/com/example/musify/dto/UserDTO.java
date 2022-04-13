package com.example.musify.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class UserDTO {
    @NotNull
    private int id;
    @NotBlank(message = "Email cannot be blank!")
    private String email;
    @NotBlank(message = "Password cannot be blank!")
    private String password;
    @NotBlank(message = "First Name cannot be blank!")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank!")
    private String lastName;
    @NotBlank(message = "Country cannot be blank!")
    private String country;
    @NotBlank(message = "Role cannot be blank!")

    private String role;

    public UserDTO() {
    }

    public UserDTO(int id, String email, String password, String firstName, String lastName,String country,String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country=country;
        this.role=role;
    }


}
