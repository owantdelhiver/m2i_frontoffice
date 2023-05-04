package com.groupe4.frontoffice.model.cart;

import com.groupe4.frontoffice.model.user.Adress;
import jakarta.persistence.*;
@Entity
public class CartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;

    public CartLine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
