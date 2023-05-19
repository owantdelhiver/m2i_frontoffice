package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.OrderService;
import com.groupe4.frontoffice.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
}