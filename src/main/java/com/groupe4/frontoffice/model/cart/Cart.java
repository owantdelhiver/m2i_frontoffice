package com.groupe4.frontoffice.model.cart;

import com.groupe4.frontoffice.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartLine> cartlines;

    public Cart() {
    }

    public Cart(int id, List<CartLine> cartlines) {
        this.id = id;
        this.cartlines = cartlines;
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

