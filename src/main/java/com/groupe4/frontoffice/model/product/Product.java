package com.groupe4.frontoffice.model.product;

import com.groupe4.frontoffice.model.order.OrderLine;
import jakarta.persistence.*;


import java.util.List;

@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private String short_description;
    private String description;
    private int stock;
    private String picture_url;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private ProductCategory category;

    public Product() {
    }

    public Product(int id, String name, float price, String short_description, String description, int stock, String picture_url, ProductCategory category, List<OrderLine> orderlines) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.short_description = short_description;
        this.description = description;
        this.stock = stock;
        this.picture_url = picture_url;
        this.category = category;
        this.orderlines = orderlines;
    }
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderLine> orderlines;
    public Product(String name, float price, String short_description, String description, int stock, String picture_url, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.short_description = short_description;
        this.description = description;
        this.stock = stock;
        this.picture_url = picture_url;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
