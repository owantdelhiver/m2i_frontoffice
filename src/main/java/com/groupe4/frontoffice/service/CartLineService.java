package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.dto.CartLineDto;
import com.groupe4.frontoffice.mapper.CartLineMapper;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.repository.cart.CartLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartLineService {
    @Autowired
    CartLineRepository cartLineRepository;

    @Autowired
    CartLineMapper cartLineMapper;

    public List<CartLine> fetchAllByIdCart(int cartId) {
        return cartLineRepository.findAllByCartId(cartId);}

    public List<CartLineDto> fetchAllByIdCartDto(int cartId) {
        List<CartLine> cartLines = cartLineRepository.findAllByCartId(cartId);
        return cartLines.stream()
                .map(cartLineMapper::cartLineToCartLineDto)
                .collect(Collectors.toList());
    }

}