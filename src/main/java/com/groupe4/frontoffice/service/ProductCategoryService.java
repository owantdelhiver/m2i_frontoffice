package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.product.ProductCategory;
import com.groupe4.frontoffice.repository.product.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    public List<ProductCategory> fetchAll(){
        return productCategoryRepository.findAll();
    }


}
