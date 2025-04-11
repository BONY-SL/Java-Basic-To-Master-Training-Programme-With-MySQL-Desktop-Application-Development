package com.springboot.academy.pointofsale.service.order;

import com.springboot.academy.pointofsale.dto.request.RequestOderSaveDTO;
import com.springboot.academy.pointofsale.dto.response.PaginatedResponseOrderDetails;

public interface OrderService {

    boolean saveNewOrder(RequestOderSaveDTO requestOderSaveDTO);

    PaginatedResponseOrderDetails getAllOrderDetails();
}
