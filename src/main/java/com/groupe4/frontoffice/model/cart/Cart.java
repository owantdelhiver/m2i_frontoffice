package com.groupe4.frontoffice.model.cart;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "cart")
    private List<CartLine> cartlines;

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CartLine> getCartlines() {
        return cartlines;
    }

    public void setCartlines(List<CartLine> cartlines) {
        this.cartlines = cartlines;
    }
}


