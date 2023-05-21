package com.groupe4.frontoffice.dto;
import com.groupe4.frontoffice.model.cart.Cart;
import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;

import java.util.List;

public class UserDto extends User {

    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;

    public UserDto() {
    }

    public UserDto(String lastname, String firstname, String email, String password, Adress adress, Cart cart, List<Order> orders, int id, String lastname1, String firstname1, String email1, String password1) {
        super(lastname, firstname, email, password, adress, cart, orders);
        this.id = id;
        this.lastname = lastname1;
        this.firstname = firstname1;
        this.email = email1;
        this.password = password1;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}

