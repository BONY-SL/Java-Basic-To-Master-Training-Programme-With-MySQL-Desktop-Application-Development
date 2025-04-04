package com.springboot.academy.pointofsale.service.order;

import com.springboot.academy.pointofsale.dto.request.RequestOderSaveDTO;

public interface OrderService {
    boolean saveNewOrder(RequestOderSaveDTO requestOderSaveDTO);
}
