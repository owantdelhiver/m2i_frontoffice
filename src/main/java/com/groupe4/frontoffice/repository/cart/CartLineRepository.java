package com.groupe4.frontoffice.repository.cart;

import com.groupe4.frontoffice.model.cart.CartLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartLineRepository extends JpaRepository<CartLine, Integer> {
}
