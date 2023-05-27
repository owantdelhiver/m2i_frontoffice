package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.product.ProductCategory;
import com.groupe4.frontoffice.service.ProductCategoryService;
import com.groupe4.frontoffice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeFilterController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductCategoryService productCategoryService;
    @PostMapping("/products-filtered")
    public String filterProductsByCategories(@RequestParam(value = "category", required = false) String[] selectedCategories, Model model) {
        List<ProductDto> filteredProducts = productService.filterProductsByCategories(selectedCategories);
        model.addAttribute("products", filteredProducts);
        List<ProductCategory> categories = productCategoryService.fetchAll();
        model.addAttribute("categories", categories);
        return "home";
    }
}
