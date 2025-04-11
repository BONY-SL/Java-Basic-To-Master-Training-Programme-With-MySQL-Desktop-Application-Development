package com.springboot.academy.pointofsale.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderDetails {

    // customer
    private String customerName;
    private String customerAddress;
    private String contactNumber;

   // order
   private Date date;
   private Double orderTotalPrice;


}
