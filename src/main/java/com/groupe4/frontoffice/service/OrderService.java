package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.order.Order;

import com.groupe4.frontoffice.repository.order.OrderLineRepository;
import com.groupe4.frontoffice.repository.order.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderLineRepository orderLineRepository;

    public Optional<Order> FindOrderById(Long id){
       return orderRepository.findById(id);
    }

    public List<Order> FindAllOrders(){
        List<Order> orderList = new ArrayList<>();
      orderList=  orderRepository.findAll();
        return orderList;
    }
    public void saveOrder(Order order){orderRepository.save(order);}

    public void deleteOrder(Order order){
        orderRepository.delete(order);}

}
