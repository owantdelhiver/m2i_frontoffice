package com.groupe4.frontoffice.model.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private OrderStatus orderStatus;


    public Order(int id, Date date, OrderStatus orderStatus, List<OrderLine> orderLines) {
        this.id = id;
        this.date = date;
        this.orderStatus = orderStatus;

    }

    public Order(int id, Date date, OrderStatus orderStatus) {
        this.id = id;
        this.date = date;
        this.orderStatus = orderStatus;
    }

    public Order() {

    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }


}
