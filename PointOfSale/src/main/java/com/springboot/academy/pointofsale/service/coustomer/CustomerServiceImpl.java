package com.springboot.academy.pointofsale.service.coustomer;

import com.springboot.academy.pointofsale.dto.CustomerDTO;
import com.springboot.academy.pointofsale.entity.Customer;
import com.springboot.academy.pointofsale.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepo customerRepo;

    @Override
    public Customer saveCustomer(CustomerDTO customerDTO) {

        Customer customer = convertCustomerDtoToCustomer(customerDTO);
        return customerRepo.save(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> customerList = customerRepo.findAll();

        return customerList.stream()
                .map(this::convertCustomerToDto)
                .toList();
    }

    private Customer convertCustomerDtoToCustomer(
            CustomerDTO customerDTO){

        // Convert Customer DTO Object To Customer Class
        return Customer.builder()
                .customerId(customerDTO.getCustomerId())
                .customerName(customerDTO.getCustomerName())
                .customerAddress(customerDTO.getCustomerAddress())
                .contactNumber(customerDTO.getContactNumber())
                .nic(customerDTO.getNic())
                .isActive(false)
        .build();
    }

    // Convert Customer to Customer DTO
    private CustomerDTO convertCustomerToDto(Customer customer){

        return CustomerDTO.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .customerAddress(customer.getCustomerAddress())
                .contactNumber(customer.getContactNumber())
                .nic(customer.getNic())
                .isActive(customer.isActive())
                .build();
    }
}
