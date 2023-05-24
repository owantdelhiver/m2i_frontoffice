package com.groupe4.frontoffice.repository.cart;

import com.groupe4.frontoffice.model.cart.CartLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartLineRepository extends JpaRepository<CartLine, Integer> {
    List<CartLine> findAllByCartId(int cartId);
    void deleteAllByCartId(int cartId);
}
