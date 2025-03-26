package com.springboot.academy.pointofsale.service.coustomer;

import com.springboot.academy.pointofsale.dto.CustomerDTO;
import com.springboot.academy.pointofsale.entity.Customer;

import java.util.List;


public interface CustomerService {

    Customer saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();
}
