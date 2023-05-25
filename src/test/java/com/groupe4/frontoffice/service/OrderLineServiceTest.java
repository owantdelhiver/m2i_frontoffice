package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.repository.order.OrderLineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OrderLineServiceTest {
    @Mock
    private OrderLineRepository orderLineRepository;

    @InjectMocks
    private OrderLineService orderLineService;

    @Test
    void shouldFetchOptionalOrderLineByIdTest() {
        OrderLine expectedOrderLine = new OrderLine();
        Optional<OrderLine> expectedOrderLineOptional = Optional.of(expectedOrderLine);

        when(orderLineRepository.findById(1L)).thenReturn(expectedOrderLineOptional);

        Optional<OrderLine> result = orderLineService.FindOrderLineById(1L);

        assertEquals(expectedOrderLineOptional, result);
    }

    @Test
    void shouldFetchAllOrderLines() {
        List<OrderLine> expectedOrderLines = new ArrayList<>();
        when(orderLineRepository.findAll()).thenReturn(expectedOrderLines);

        List<OrderLine> result = orderLineService.FindAllOrderLines();

        assertEquals(expectedOrderLines, result);
    }


    @Test
    void shouldDeleteOrderLine() {
        OrderLine orderLine = new OrderLine();
        orderLineService.deleteOrderLine(orderLine);
        verify(orderLineRepository).delete(orderLine);
    }

    @Test
    void shouldSaveOrderLine() {
        OrderLine orderLine = new OrderLine();
        orderLineService.saveOrderLine(orderLine);
        verify(orderLineRepository).save(orderLine);
    }

    @Test
    void shouldConvertCartLineToOrderLine() {

        CartLine cartLine = new CartLine();
        Product product = new Product();
        int quantity = 1;
        cartLine.setProduct(product);
        cartLine.setQuantity(quantity);

        OrderLine orderLine = orderLineService.convertCartLine(cartLine);

        assertEquals(quantity, orderLine.getQuantity());
        assertEquals(product, orderLine.getProduct());
    }

    @Test
    void shouldConvertCartLinesToOrderLines() {

        List<CartLine> cartLines = new ArrayList<>();
        CartLine cartLine1 = new CartLine();
        Product product1 = new Product();
        int quantity1 = 1;
        cartLine1.setProduct(product1);
        cartLine1.setQuantity(quantity1);
        cartLines.add(cartLine1);

        CartLine cartLine2 = new CartLine();
        Product product2 = new Product();
        int quantity2 = 2;
        cartLine2.setProduct(product2);
        cartLine2.setQuantity(quantity2);
        cartLines.add(cartLine2);

        List<OrderLine> orderLines = orderLineService.convertCartLines(cartLines);

        assertEquals(2, orderLines.size());

        OrderLine orderLine1 = orderLines.get(0);
        assertEquals(quantity1, orderLine1.getQuantity());
        assertEquals(product1, orderLine1.getProduct());

        OrderLine orderLine2 = orderLines.get(1);
        assertEquals(quantity2, orderLine2.getQuantity());
        assertEquals(product2, orderLine2.getProduct());
    }
}
