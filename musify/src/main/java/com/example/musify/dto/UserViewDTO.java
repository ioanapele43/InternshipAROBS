package com.example.musify.dto;

public class UserViewDTO {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String fullName;
    public UserViewDTO(){
    }
    public UserViewDTO(int id, String email,String firstName,String lastName, String fullName){
        this.id=id;
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.fullName=fullName;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
