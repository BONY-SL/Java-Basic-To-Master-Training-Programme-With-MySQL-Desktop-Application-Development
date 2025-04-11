package com.springboot.academy.pointofsale.dto.request;

import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestOderSaveDTO {

    private Integer customer;
    private Date date;
    private Double orderTotalPrice;
    private List<RequestOrderItemDTO> orderItemDTOList;

    @Override
    public String toString() {
        return "RequestOderSaveDTO{" +
                ", customer=" + customer +
                ", date=" + date +
                ", orderTotalPrice=" + orderTotalPrice +
                ", orderItemDTOList=" + orderItemDTOList +
                '}';
    }
}
