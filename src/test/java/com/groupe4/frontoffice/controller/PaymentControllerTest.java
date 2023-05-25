package com.groupe4.frontoffice.controller;

import com.groupe4.frontoffice.model.cart.Cart;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.service.CartLineService;
import com.groupe4.frontoffice.service.OrderLineService;
import com.groupe4.frontoffice.service.OrderService;
import com.groupe4.frontoffice.service.ProductService;
import com.groupe4.frontoffice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PaymentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CartLineService cartLineService;

    @Mock
    private OrderLineService orderLineService;

    @Mock
    private OrderService orderService;

    @Mock
    private UserService userService;

    @Mock
    private ProductService productService;

    @InjectMocks
    private PaymentController paymentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    void testCart() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/payment"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("payment-tunnel"));
    }

    @Test
    void testConvertCart() throws Exception {

        MockHttpSession session = new MockHttpSession();
        User user = new User();

        Cart cart = new Cart();
        user.setCart(cart);

        List<CartLine> cartLines = new ArrayList<>();
        List<OrderLine> orderLines = new ArrayList<>();

        Product product = new Product();
        product.setId(1);

        CartLine cartLine = new CartLine();
        cartLine.setProduct(product);
        cartLine.setQuantity(1);
        cartLines.add(cartLine);

        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(product);
        orderLine.setQuantity(1);
        orderLines.add(orderLine);

        when(paymentController.getUserSession(session)).thenReturn(user);
        when(cartLineService.fetchAllByIdCart(cart.getId())).thenReturn(cartLines);
        when(orderLineService.convertCartLines(cartLines)).thenReturn(orderLines);

        mockMvc.perform(post("/place-order").session(session))
                .andExpect(redirectedUrl("/orders"));

        verify(orderService, times(1)).generateOrder(user, orderLines);
        verify(productService, times(1)).updateProductsStock(orderLines);
        verify(cartLineService, times(1)).deleteAllByCartId(cart.getId());
    }
}