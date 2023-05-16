////package com.groupe4.frontoffice;
////
////import com.groupe4.frontoffice.model.cart.Cart;
//import com.groupe4.frontoffice.model.cart.CartLine;
//import com.groupe4.frontoffice.model.product.Product;
//import com.groupe4.frontoffice.model.product.ProductCategory;
//import com.groupe4.frontoffice.model.user.Adress;
//import com.groupe4.frontoffice.model.user.User;
//import com.groupe4.frontoffice.repository.cart.CartLineRepository;
//import com.groupe4.frontoffice.repository.cart.CartRepository;
//import com.groupe4.frontoffice.repository.product.ProductCategoryRepository;
//import com.groupe4.frontoffice.repository.product.ProductRepository;
//import com.groupe4.frontoffice.repository.user.AdressRepository;
//import com.groupe4.frontoffice.repository.user.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Arrays;
//
//@SpringBootApplication
//public class SpringDataJpaApplication implements CommandLineRunner {
//
//    @Autowired
//    private CartLineRepository cartLineRepository;
//    @Autowired
//    private CartRepository cartRepository;
//    @Autowired
//    private ProductCategoryRepository productCategoryRepository;
//    @Autowired
//    private ProductRepository productRepository;
//    @Autowired
//    private AdressRepository adressRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringDataJpaApplication.class, args);
//    }
//
//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
//        System.out.println("Exécuté au lancement du serveur : Pratique pour tester JPA");
//
//        ProductCategory productCategory = new ProductCategory("Processor");
//        productCategoryRepository.save(productCategory);
//
//        Product product = new Product("GTX 3080", 2, "Un processeur", "Un long processeur", 3, "pictureurl",new ProductCategory("GPU"));
//        productRepository.save(product);
//
//        Adress adress = new Adress("toto", 3, 44000, "Nantes", "France", "Where toto lives");
//        adressRepository.save(adress);
//
//        User user = new User("toto", "toto", "toto@toto", "toto", adress, new Cart());
//        userRepository.save(user);
//
//        CartLine cartLine = new CartLine(new Cart(), product, 7);
//        cartLineRepository.save(cartLine);
//    }
//}
