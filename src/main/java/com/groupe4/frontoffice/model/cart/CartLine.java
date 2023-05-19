package com.groupe4.frontoffice.model.cart;

import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.user.Adress;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;
    private int quantity;

    public CartLine() {
    }

    public CartLine(Cart cart, Product product, int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }


}
