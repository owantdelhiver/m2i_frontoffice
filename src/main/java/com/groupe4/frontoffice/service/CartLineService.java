package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.repository.cart.CartLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartLineService {
    @Autowired
    CartLineRepository cartLineRepository;

    public List<CartLine> fetchAll(){
        return cartLineRepository.findAll();
    }
}