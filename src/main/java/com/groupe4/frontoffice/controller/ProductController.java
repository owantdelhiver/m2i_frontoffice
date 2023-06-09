package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ProductController extends SuperController {
    @Autowired
    ProductService productService;

        @GetMapping("product/{id}")
        public String getProductbyId(@PathVariable int id, Model model) {
            model.addAttribute("product", productService.getById(id));
            model.addAttribute("cartLine", new CartLine());
            return "product";
    }

}
