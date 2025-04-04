package com.springboot.academy.pointofsale.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "Order")
@Table(name = "orders")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    @Column(name = "order_date" , columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "order_total_price")
    private Double orderTotalPrice;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", date=" + date +
                ", orderTotalPrice=" + orderTotalPrice +
                ", orderItems=" + orderItems +
                '}';
    }

    public Order(Customer customer, Date date, Double orderTotalPrice) {
        this.customer = customer;
        this.date = date;
        this.orderTotalPrice = orderTotalPrice;
    }
}
