package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.mapper.ProductMapper;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.*;
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

    public Product getFullProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
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


    public List<ProductDto> filterByKeyword(String keyword) {
        List<ProductDto> filteredProductDtos = new ArrayList<>();
        List<ProductDto> productsDtos = fetchAll();

        for (ProductDto productDto : productsDtos) {
            if (productDto.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    productDto.getDescription().toLowerCase().contains(keyword.toLowerCase()) ||
                        productDto.getCategory().getName().toLowerCase().contains(keyword.toLowerCase())) {
                filteredProductDtos.add(productDto);
            }
        }
        return filteredProductDtos;
    }

    public List<ProductDto> filterProductsByCategories(String[] selectedCategories) {
        if (selectedCategories == null || selectedCategories.length == 0) {
            return fetchAll();
        } else {
            List<Integer> categoryIds = Arrays.stream(selectedCategories)
                    .map(Integer::parseInt)
                    .toList();
            List<ProductDto> filteredProductDtos = new ArrayList<>();
            List<ProductDto> productsDtos = fetchAll();

            for (ProductDto productDto : productsDtos) {
                if (categoryIds.contains(productDto.getCategory().getId())) {
                    filteredProductDtos.add(productDto);
                }
            }
            return filteredProductDtos;
        }
    }
}

