package com.springboot.academy.pointofsale.controller;

import com.springboot.academy.pointofsale.dto.CustomerDTO;
import com.springboot.academy.pointofsale.dto.request.CustomerUpdateDTO;
import com.springboot.academy.pointofsale.exceptions.CustomerNotFoundException;
import com.springboot.academy.pointofsale.exceptions.haddlers.AppWideExceptionHandler;
import com.springboot.academy.pointofsale.service.coustomer.CustomerService;
import com.springboot.academy.pointofsale.util.StandardResponse;
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

    private final AppWideExceptionHandler appWideExceptionHandler;

    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customer){
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @GetMapping ("/get-all")
    public ResponseEntity<StandardResponse> getAllCustomers(){

        return new ResponseEntity<>(new StandardResponse(200, "Customer found", customerService.getAllCustomers()),
                HttpStatus.OK);
    }

    @PutMapping("/custom-update")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        return ResponseEntity.ok(customerService.updateCustomer(customerUpdateDTO));
    }

    @GetMapping(path = "/get-customer-byID"
            ,params = "customerId"
    )
    public ResponseEntity<StandardResponse> getCustomerByID(@RequestParam(value = "customerId") Integer customerId){

        CustomerDTO customerDTO = customerService.getCustomerByID(customerId);
        try {
            return new ResponseEntity<>(new StandardResponse(
                    200,
                    "Customer found",
                    customerDTO),
                    HttpStatus.OK);

        }catch (CustomerNotFoundException e){
            return appWideExceptionHandler.handleCustomerNotFound(e);
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

//    @AppWideExceptionHandler(CustomerNotFoundException.class)
//    public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException ex) {
//        // Return a custom error message with a 404 NOT FOUND status
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//    }