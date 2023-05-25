package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.order.OrderStatus;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.order.OrderRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
//    @Mock
//    private OrderRepository orderRepository;
//
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private OrderService orderService;
//
//    @BeforeEach
//    void setUp() {
//        userService = new UserService();
//    }
//
//
//    @Test
//    public void testGenerateOrder() {
//
//        User user = new User();
//        user.setId(1);
//        List<OrderLine> orderLines = new ArrayList<>();
//        Order savedOrder = new Order(new Date(), OrderStatus.VALIDATED, orderLines, user);
//
//
//        when(userService.fetchById(user.getId())).thenReturn(user);
//        when(orderRepository.save(any(Order.class))).thenReturn(savedOrder);
//
//        orderService.generateOrder(user, orderLines);
//
//        verify(userService).fetchById(user.getId());
//        verify(orderRepository).save(savedOrder);
//
//        assertEquals(user, savedOrder.getUser());
//        assertEquals(orderLines, savedOrder.getOrderLineList());
//        for (OrderLine orderLine : orderLines) {
//            assertEquals(savedOrder, orderLine.getOrder());
//        }
//    }
}
