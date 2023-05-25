package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.mapper.ProductMapper;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    public List<ProductDto> fetchAll(){
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto getById(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(productMapper::productToProductDto).orElse(null);
    }

    public void updateProductStock(int newStock, int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            System.out.println(product.getName() + " stock is " + product.getStock());
            product.setStock(newStock);
            System.out.println(product.getName() + " stock is " + newStock);
            productRepository.save(product);
        }
    }

    public void updateProductsStock(List<OrderLine> orderLines) {
        for (OrderLine orderLine : orderLines) {
            Product product = orderLine.getProduct();
            int newStock = product.getStock() - orderLine.getQuantity();
            updateProductStock(newStock, (int) product.getId());
        }
    }
}

