package com.groupe4.frontoffice.dto;

import com.groupe4.frontoffice.model.cart.Cart;
import com.groupe4.frontoffice.model.product.Product;
import jakarta.persistence.*;

public class CartLineDto {

    private int id;
    private ProductDto productDto;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTotal() {
        if (productDto != null) {
            double total = quantity * productDto.getPrice();
            return String.format("%.2f", total);
        } else {
            return "0.00";
        }
    }
}
