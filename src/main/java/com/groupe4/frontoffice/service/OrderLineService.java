package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.repository.OrderLineRepository;
import com.groupe4.frontoffice.repository.OrderRepository;
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

    public Optional<OrderLine> FindOrderLineById(Long id){
        return orderLineRepository.findById(id);
    }

    public List<OrderLine> FindAllOrderLines(){

        List<OrderLine> orderLinesList = new ArrayList<>();
        orderLineRepository.findAll();
        return orderLinesList;
    }

    public void saveOrderLine(OrderLine orderline){
        orderLineRepository.save(orderline);}

    public void deleteOrderLine(OrderLine orderline){
        orderLineRepository.delete(orderline);}
}
