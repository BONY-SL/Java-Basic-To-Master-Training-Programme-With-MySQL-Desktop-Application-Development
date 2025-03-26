package com.springboot.academy.pointofsale.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


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
