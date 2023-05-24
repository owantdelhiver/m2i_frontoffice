package com.groupe4.frontoffice.dto;

import com.groupe4.frontoffice.model.order.OrderLine;
import com.groupe4.frontoffice.model.order.OrderStatus;

import java.util.Date;
import java.util.List;

public class OrderDto {
    private int id;
    private Date date;
    private OrderStatus orderStatus;
    private List<OrderLineDto> orderLineDtoList;

    public String getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderLineDto orderLineDto : orderLineDtoList) {
            int quantity = orderLineDto.getQuantity();
            double price = orderLineDto.getProductDto().getPrice();
            totalPrice += quantity * price;
        }
        return String.format("%.2f", totalPrice);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderLineDto> getOrderLineDtoList() {
        return orderLineDtoList;
    }

    public void setOrderLineList(List<OrderLineDto> orderLineDtoList) {
        this.orderLineDtoList = orderLineDtoList;
    }
}
