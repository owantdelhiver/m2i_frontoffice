package com.groupe4.frontoffice.api;

import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.service.OrderLineService;
import com.groupe4.frontoffice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api2")
public class OrderLineRestController {
@Autowired
OrderLineService orderLineService;

@RequestMapping(value="/orderLines")
public List<OrderLine> findAll(){
        return orderLineService.FindAllOrderLines();
    }
@RequestMapping(value="/{id}")
public Optional<OrderLine> findbyId(Long id){
return orderLineService.FindOrderLineById(id);}

public void save(OrderLine orderLine){
        orderLineService.saveOrderLine(orderLine);
    }

 public void delete(OrderLine orderLine){
        orderLineService.deleteOrderLine(orderLine);
    }

}


