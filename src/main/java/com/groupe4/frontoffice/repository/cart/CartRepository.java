package com.groupe4.frontoffice.repository.cart;

import com.groupe4.frontoffice.model.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
