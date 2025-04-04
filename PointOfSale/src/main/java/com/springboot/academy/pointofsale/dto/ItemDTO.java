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

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", measuringUnitType=" + measuringUnitType +
                ", balanceQty=" + balanceQty +
                ", supplierPrice=" + supplierPrice +
                ", sellingPrice=" + sellingPrice +
                ", available=" + available +
                '}';
    }
}
