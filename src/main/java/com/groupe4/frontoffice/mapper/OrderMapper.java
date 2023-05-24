package com.groupe4.frontoffice.mapper;

import com.groupe4.frontoffice.dto.CartLineDto;
import com.groupe4.frontoffice.dto.OrderDto;
import com.groupe4.frontoffice.dto.OrderLineDto;
import com.groupe4.frontoffice.dto.ProductDto;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.order.Order;
import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);

    @Mapping(target = "productDto", source = "orderLine.product")
    OrderLineDto orderLineToOrderLineDto(OrderLine orderLine);

    ProductDto productToProductDto(Product product);

    default List<OrderLineDto> orderLineListToOrderLineDtoList(List<OrderLine> orderLineList) {
        return orderLineList.stream()
                .map(this::orderLineToOrderLineDto)
                .collect(Collectors.toList());
    }
}
