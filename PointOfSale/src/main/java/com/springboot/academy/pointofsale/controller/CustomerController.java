package com.springboot.academy.pointofsale.controller;

import com.springboot.academy.pointofsale.dto.CustomerDTO;
import com.springboot.academy.pointofsale.entity.Customer;
import com.springboot.academy.pointofsale.service.coustomer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/custom")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDTO customer){
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @GetMapping ("/get-all")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){

        return ResponseEntity.ok(customerService.getAllCustomers());
    }
}
