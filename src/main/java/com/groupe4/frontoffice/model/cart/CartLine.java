package com.groupe4.frontoffice.model.cart;

import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.user.Adress;
import jakarta.persistence.*;
@Entity
public class CartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    private int quantity;

    public CartLine() {
    }

    public CartLine(int id, Cart cart, Product product, int quantity) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public CartLine(Cart cart, Product product, int quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public String getTotal() {
        if (product != null) {
            double total = quantity * product.getPrice();
            return String.format("%.2f", total);
        } else {
            return "0.00";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
