package com.springboot.academy.pointofsale.controller;

import com.springboot.academy.pointofsale.dto.request.RequestOderSaveDTO;
import com.springboot.academy.pointofsale.service.order.OrderService;
import com.springboot.academy.pointofsale.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/save-order")
    public ResponseEntity<StandardResponse> saveNewOrder(@RequestBody RequestOderSaveDTO requestOderSaveDTO){

        boolean isAdded = orderService.saveNewOrder(requestOderSaveDTO);
        System.out.println(requestOderSaveDTO);

        if(isAdded){
            return  new ResponseEntity<>(
                    new StandardResponse(
                            HttpStatus.CREATED.value(),
                            "New Order Added Success",
                            null
                    ),HttpStatus.CREATED
            );
        }else {
            return  new ResponseEntity<>(
                    new StandardResponse(
                            HttpStatus.NO_CONTENT.value(),
                            "New Order Not Added Success",
                            null
                    ),HttpStatus.NO_CONTENT
            );
        }
    }
}
