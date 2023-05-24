package com.groupe4.frontoffice.controller;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.CartLineService;
import com.groupe4.frontoffice.service.ProductService;
import com.groupe4.frontoffice.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CartLineController extends SuperController {

    @Autowired
    CartLineService cartLineService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @PostMapping("/add-to-cart/{id}")
    public String saveItemToCartLine(@PathVariable int id, CartLine cartLine, HttpSession httpsession) {
        if(getUserSession(httpsession).getEmail()!=null){
        User user = super.getUserSession(httpsession);
        Product product=productService.getById(id);
        cartLine.setProduct(product);
        userService.addCartLine(user, cartLine);
        return "redirect:/cart";
    } else {return "redirect:/login";}
}}
