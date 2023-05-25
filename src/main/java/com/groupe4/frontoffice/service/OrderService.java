package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.dto.OrderDto;
//import com.groupe4.frontoffice.mapper.OrderLineMapper;
import com.groupe4.frontoffice.mapper.OrderMapper;
import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.order.OrderStatus;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.order.OrderLineRepository;
import com.groupe4.frontoffice.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderLineRepository orderLineRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserService userService;

//    @Autowired
//    OrderLineMapper orderLineMapper;

    public Optional<OrderDto> findOrderById(int id) {
        Optional<Order> orderOptional = orderRepository.findById((long) id);
        return orderOptional.map(order -> orderMapper.orderToOrderDto(order));
    }

    public List<Order> FindAllOrders(){
        List<Order> orderList;
        orderList=  orderRepository.findAll();
        return orderList;
    }
    public void saveOrder(Order order){orderRepository.save(order);}

    public void deleteOrder(Order order){
        orderRepository.delete(order);}

    public List<OrderDto> findOrdersByUserId(int id) {
        List<Order> orderList = orderRepository.findAllByUserId(id);
        return orderList.stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }

    public Optional<Order> findOrderByIdRest(int id) { return orderRepository.findById((long) id);
    }

    public void generateOrder(User user, List<OrderLine> orderLines) {
        Order order = new Order(new Date(), OrderStatus.VALIDATED, orderLines, userService.fetchById(user.getId()));
        orderLines.forEach(orderLine -> orderLine.setOrder(order));
        saveOrder(order);
    }
}
