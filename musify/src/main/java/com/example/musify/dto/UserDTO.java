package com.example.musify.dto;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
