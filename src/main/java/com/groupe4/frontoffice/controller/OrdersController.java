package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.OrderService;
import com.groupe4.frontoffice.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class OrdersController extends SuperController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public String orders(Model model, HttpSession session) {
        User user = super.getUserSession(session);
        model.addAttribute("orders", orderService.findOrdersByUserId(user.getId()));
        return "orders";
    }

    @GetMapping("/order/{id}")
    public String order(@PathVariable("id") int id, Model model) {
        Optional<Order> order = orderService.findOrderById(id);
        if (order.isPresent()) {
            model.addAttribute("orderlines", order.get().getOrderLineList());
        } else {
            return "home";
        }
        return "order";
    }
}