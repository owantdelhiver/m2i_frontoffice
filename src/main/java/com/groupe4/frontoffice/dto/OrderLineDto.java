package com.groupe4.frontoffice.dto;

import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.model.product.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderLineDto {
    private int id;
    private int quantity;

    private ProductDto productDto;
    public String getTotal() {
        if (productDto != null) {
            double total = quantity * productDto.getPrice();
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
