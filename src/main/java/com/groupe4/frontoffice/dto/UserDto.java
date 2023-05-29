package com.groupe4.frontoffice.dto;

import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;


public class UserDto {
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private AdressDto adress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public AdressDto getAdress() {
        return adress;
    }

    public void setAdress(AdressDto adress) {
        this.adress = adress;
    }
}