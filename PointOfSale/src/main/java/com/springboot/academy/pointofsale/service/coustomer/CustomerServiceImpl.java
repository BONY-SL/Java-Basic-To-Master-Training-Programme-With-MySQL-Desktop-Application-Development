package com.springboot.academy.pointofsale.service.coustomer;

import com.springboot.academy.pointofsale.dto.CustomerDTO;
import com.springboot.academy.pointofsale.dto.request.CustomerUpdateDTO;
import com.springboot.academy.pointofsale.entity.Customer;
import com.springboot.academy.pointofsale.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        Optional<Customer> customerOptional = customerRepo.findById(customerUpdateDTO.getCustomerId());

        if(customerOptional.isPresent()){

            customerOptional.get().setCustomerName(customerUpdateDTO.getCustomerName());
            customerOptional.get().setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customerOptional.get().setContactNumber(customerUpdateDTO.getContactNumber());

            customerRepo.save(customerOptional.get());
            return "Customer Details Update Successfully";
        }else {
            return "Invalid Customer ID";
        }
    }

    @Override
    public CustomerDTO getCustomerByID(Integer customerId) {

        Optional<Customer> customerOptional = customerRepo.findById(customerId);
        return customerOptional.map(this::convertCustomerToDto).orElse(null);

    }

    @Override
    public String deleteCustomer(Integer customerID) {

        Optional<Customer> customerOptional = customerRepo.findById(customerID);

        if(customerOptional.isPresent()){
            customerRepo.delete(customerOptional.get());
            return "Customer Deleted Successfully";
        }else {
            return "Invalid Customer ID Customer Deleted Not Successfully";
        }
    }

    @Override
    public List<CustomerDTO> getCustomersByStatus(boolean status) {

        List<Customer> customerList = customerRepo.findAllByActiveEquals(status);

        return customerList.stream()
                .map(this::convertCustomerToDto).toList();
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
//        if(customerOptional.isPresent()){
//            return convertCustomerToDto(customerOptional.get());
//        }else {
//            throw new CustomerNotFoundException("Customer Not Found With ID: "+ customerId);
//        }