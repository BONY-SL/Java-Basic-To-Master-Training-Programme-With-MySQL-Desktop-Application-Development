package com.springboot.academy.pointofsale.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity(name = "Customer")
@Table(name = "customer")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name", length = 150, nullable = false)
    private String customerName;

    @Column(name = "cus_address", nullable = false)
    private String customerAddress;

    @Column(name = "conts_number")
    private String contactNumber;

    @Column(name = "nic_number")
    private String nic;

    @Column(name = "active_status")
    private boolean isActive;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orderList;

    @Override
    public String toString() {
        return "CustomerService{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", NIC='" + nic + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
