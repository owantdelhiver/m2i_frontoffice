package com.groupe4.frontoffice.model.order;

import com.groupe4.frontoffice.model.product.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    public OrderLine(int id, Product product, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    public OrderLine() {

    }
    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
}
