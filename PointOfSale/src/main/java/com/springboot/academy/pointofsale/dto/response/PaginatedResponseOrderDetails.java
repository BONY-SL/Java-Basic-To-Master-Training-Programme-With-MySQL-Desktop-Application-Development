package com.springboot.academy.pointofsale.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseOrderDetails {

    private List<ResponseOrderDetails> orderDetailsList;
    private long count;
}
