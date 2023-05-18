package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.cart.Cart;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.product.ProductCategory;
import com.groupe4.frontoffice.model.user.Adress;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.order.OrderRepository;
import com.groupe4.frontoffice.repository.cart.CartLineRepository;
import com.groupe4.frontoffice.repository.cart.CartRepository;
import com.groupe4.frontoffice.repository.product.ProductCategoryRepository;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import com.groupe4.frontoffice.repository.user.AdressRepository;
import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
@Controller
public class TestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/auth/test")
    public String test() {
//        User newUser = new User("tata", "tata", passwordEncoder.encode("tata@tata.fr"), "tata", new Cart());
//        userRepository.save(newUser);
        return "test";
    }
}
