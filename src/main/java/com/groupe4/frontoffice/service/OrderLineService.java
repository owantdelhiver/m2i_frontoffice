package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.repository.order.OrderLineRepository;
import com.groupe4.frontoffice.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    @Autowired
    OrderRepository orderRepository;

    public Optional<OrderLine> FindOrderLineById(Long id) {
        return orderLineRepository.findById(id);
    }

    public List<OrderLine> FindAllOrderLines() {

        List<OrderLine> orderLinesList = new ArrayList<>();
        orderLineRepository.findAll();
        return orderLinesList;
    }

    public void saveOrderLine(OrderLine orderline) {
        orderLineRepository.save(orderline);
    }

    public void deleteOrderLine(OrderLine orderline) {
        orderLineRepository.delete(orderline);
    }

    public OrderLine convertCartLine(CartLine cartline) {
        Product product = cartline.getProduct();
        int quantity = cartline.getQuantity();
        return new OrderLine(quantity, product);
    }

    public List<OrderLine> convertCartLines(List<CartLine> cartLines) {
        List<OrderLine> orderLines = new ArrayList<>();
        for (CartLine cartLine : cartLines) {
            orderLines.add(convertCartLine(cartLine));
        }
        return orderLines;
    }
}
