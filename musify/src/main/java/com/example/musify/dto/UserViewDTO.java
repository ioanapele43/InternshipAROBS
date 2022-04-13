package com.example.musify.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
