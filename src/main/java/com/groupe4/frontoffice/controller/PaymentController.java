package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class PaymentController extends SuperController {
    @Autowired
    CartLineService cartLineService;

    @Autowired
    OrderLineService orderLineService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping("/payment")
    public String cart() {
        return "payment-tunnel";
    }

    @PostMapping("/place-order")
    public String convertCart(HttpSession session) {

        User user = super.getUserSession(session);

        // Fetching the cartlines
        List<CartLine> cartLines = cartLineService.fetchAllByIdCart(user.getCart().getId());
        // Converting them into orderlines
        List<OrderLine> orderLines = orderLineService.convertCartLines(cartLines);
        // Creating and saving the order
        orderService.generateOrder(user, orderLines);
        // Updating the stock
        productService.updateProductsStock(orderLines);
        // Emptying the cart
        cartLineService.deleteAllByCartId(user.getCart().getId());
        return "redirect:/orders";
    }
}