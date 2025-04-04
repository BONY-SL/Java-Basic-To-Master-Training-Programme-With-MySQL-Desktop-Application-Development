package com.springboot.academy.pointofsale.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_item")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", order=" + order.getId() +
                ", item=" + item.getId() +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
