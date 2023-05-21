package com.groupe4.frontoffice.model.user;
import jakarta.persistence.*;


@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private int number;
    private int zipcode;
    private String city;
    private String country;
    private String extraInfo;

    public Adress() {
    }

    public Adress(String street, int number, int zipcode, String city, String country, String extraInfo) {
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
        this.extraInfo = extraInfo;
    }

    public int getId() {
        return id;
    }

    public Adress setId(int id) {
        this.id = id;
        return Adress.this;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }


}
