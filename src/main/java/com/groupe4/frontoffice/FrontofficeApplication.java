package com.groupe4.frontoffice;

import com.groupe4.frontoffice.model.cart.Cart;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.cart.CartLineRepository;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontofficeApplication implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartLineRepository cartLineRepository;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(FrontofficeApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//        Product product1 = new Product();
//        productRepository.save(product1);
//        Product product2 = new Product();
//        productRepository.save(product2);
//
//        CartLine cartline1 = new CartLine();
//        cartLineRepository.save(cartline1);
//
//        User user1 = new User("a", "b", "lol@email.fr", "", new Cart());
//        userRepository.save(user1);

    }
}
