package com.springboot.academy.pointofsale.controller;

import com.springboot.academy.pointofsale.dto.CustomerDTO;
import com.springboot.academy.pointofsale.dto.request.CustomerUpdateDTO;
import com.springboot.academy.pointofsale.entity.Customer;
import com.springboot.academy.pointofsale.service.coustomer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/custom-update")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        return ResponseEntity.ok(customerService.updateCustomer(customerUpdateDTO));
    }

    @GetMapping(path = "/get-customer-byID"
            ,params = "customerId"
    )
    public ResponseEntity<?> getCustomerByID(@RequestParam(value = "customerId") Integer customerId){

        CustomerDTO customerDTO = customerService.getCustomerByID(customerId);
        if(customerDTO != null){
            return ResponseEntity.ok(customerDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer Not Found Invalid ID");
        }
    }

    @DeleteMapping(
              "/delete-customer/{getId}"
    )
    public ResponseEntity<String> deleteCustomer(@PathVariable (value = "getId")Integer customerID){

        return ResponseEntity.ok(customerService.deleteCustomer(customerID));

    }

    @GetMapping(path = "/get-customers-by-status",
                params = "status")
    public ResponseEntity<List<CustomerDTO>> getCustomersByStatus(@RequestParam(value = "status")boolean status){

        return ResponseEntity.ok(customerService.getCustomersByStatus(status));
    }
}
//        try {
//            CustomerDTO customerDTO = customerService.getCustomerByID(customerId);
//            return ResponseEntity.ok(customerDTO);
//        } catch (CustomerNotFoundException ex) {
//            return handleCustomerNotFoundException(ex);
//        }

//    @ExceptionHandler(CustomerNotFoundException.class)
//    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException ex) {
//        // Return a custom error message with a 404 NOT FOUND status
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//    }