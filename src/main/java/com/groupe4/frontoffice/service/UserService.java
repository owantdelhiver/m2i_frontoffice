package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.product.ProductRepository;
import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> fetchAll(){
        return userRepository.findAll();
    }
}