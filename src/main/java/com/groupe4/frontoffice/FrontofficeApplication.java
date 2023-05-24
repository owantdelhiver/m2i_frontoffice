package com.groupe4.frontoffice;

import com.groupe4.frontoffice.repository.cart.CartLineRepository;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontofficeApplication  {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartLineRepository cartLineRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FrontofficeApplication.class, args);
    }
}

