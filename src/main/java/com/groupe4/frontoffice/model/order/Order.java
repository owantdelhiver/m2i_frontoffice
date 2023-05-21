package com.groupe4.frontoffice.model.order;

import com.groupe4.frontoffice.model.user.User;
import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLineList;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Order(int id, Date date, OrderStatus orderStatus, List<OrderLine> orderLineList, User user) {
        this.id = id;
        this.date = date;
        this.orderStatus = orderStatus;
        this.orderLineList = orderLineList;
        this.user = user;
    }

    public Order() {
    }

    public Order(int id, Date date, OrderStatus orderStatus) {
        this.id = id;
        this.date = date;
        this.orderStatus = orderStatus;


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

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
