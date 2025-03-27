package com.springboot.academy.pointofsale.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateDTO {

    private Integer customerId;

    private String customerName;

    private String customerAddress;

    private String contactNumber;
}
