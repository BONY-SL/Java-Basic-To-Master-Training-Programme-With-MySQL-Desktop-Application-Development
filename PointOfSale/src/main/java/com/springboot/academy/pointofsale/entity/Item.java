package com.springboot.academy.pointofsale.entity;

import com.springboot.academy.pointofsale.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "Item")
@Table(name = "item")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_type" , nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty" , nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price" , nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price" , nullable = false)
    private double sellingPrice;

    @Column(name = "available_status")
    private boolean available;

    @OneToMany(mappedBy = "item")
    private Set<OrderItem> orderItems;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", measuringUnitType=" + measuringUnitType +
                ", balanceQty=" + balanceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                ", isAvailable=" + available +
                '}';
    }
}
