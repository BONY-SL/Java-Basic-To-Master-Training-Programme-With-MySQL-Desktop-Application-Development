package com.springboot.academy.pointofsale.dto.request;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderItemDTO {

    private Integer id;
    private Integer order;
    private Integer item;
    private double quantity;
    private double totalPrice;

    @Override
    public String toString() {
        return "RequestOrderItemDTO{" +
                "id=" + id +
                ", order=" + order +
                ", item=" + item +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
