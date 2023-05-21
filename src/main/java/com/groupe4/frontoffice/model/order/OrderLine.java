package com.groupe4.frontoffice.model.order;
import com.groupe4.frontoffice.model.product.Product;
import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    public OrderLine(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public String getTotal() {
        if (product != null) {
            double total = quantity * product.getPrice();
            return String.format("%.2f", total);
        } else {
            return "0.00";
        }
    }


    public OrderLine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
