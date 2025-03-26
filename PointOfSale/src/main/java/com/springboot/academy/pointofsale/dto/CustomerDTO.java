package com.springboot.academy.pointofsale.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Integer customerId;

    private String customerName;

    private String customerAddress;

    private String contactNumber;

    private String nic;

    private boolean isActive;
}
