package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.cart.Cart;
import com.groupe4.frontoffice.model.user.Role;
import com.groupe4.frontoffice.repository.cart.CartRepository;
import com.groupe4.frontoffice.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public Cart getById(int id) {
        return cartRepository.findById(id).get();
    }
}
