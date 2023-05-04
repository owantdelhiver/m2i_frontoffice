package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> fetchAll(){
        return productRepository.findAll();
    }
}
