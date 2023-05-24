package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.order.OrderStatus;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.order.OrderLineRepository;
import com.groupe4.frontoffice.repository.order.OrderRepository;
import com.groupe4.frontoffice.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class CartController extends SuperController {
    @Autowired
    CartLineService cartLineService;

    @Autowired
    OrderLineService orderLineService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        User user = super.getUserSession(session);
        model.addAttribute("cartlines", cartLineService.fetchAllByIdCartDto(user.getCart().getId()));
        return "cart";
    }
}
