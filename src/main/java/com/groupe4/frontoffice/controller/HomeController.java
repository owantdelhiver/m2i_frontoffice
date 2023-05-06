package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.fetchAll());
        return "home";
    }
}
