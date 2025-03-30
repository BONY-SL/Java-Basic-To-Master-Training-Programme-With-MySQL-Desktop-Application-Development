package com.springboot.academy.pointofsale.dto;

import com.springboot.academy.pointofsale.entity.enums.MeasuringUnitType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private Integer id;

    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;

    private boolean available;

}
