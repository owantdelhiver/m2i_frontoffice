package com.groupe4.frontoffice.api;

import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.service.OrderLineService;
import com.groupe4.frontoffice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderLineService orderLineService;

  @RequestMapping(value="/orders")
    public List<Order> findAll(){
      return orderService.FindAllOrders();
  }
    @RequestMapping(value="/{id}")
    public Optional<Order> findbyId(Long id){
        return orderService.FindOrderById(id);}

    public void save(Order order){
      orderService.saveOrder(order);
    }

    public void delete(Order order){
        orderService.deleteOrder(order);
    }

}
