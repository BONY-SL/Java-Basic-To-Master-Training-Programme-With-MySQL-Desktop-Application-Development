package com.springboot.academy.pointofsale.exceptions.haddlers;

import com.springboot.academy.pointofsale.exceptions.CustomerNotFoundException;
import com.springboot.academy.pointofsale.exceptions.ItemNotFound;
import com.springboot.academy.pointofsale.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<StandardResponse> handleCustomerNotFound(CustomerNotFoundException exception) {
        StandardResponse response = new StandardResponse(
                HttpStatus.NOT_FOUND.value(),
                "Customer Not Found",
                exception.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemNotFound.class)
    public ResponseEntity<StandardResponse> itemsNotFoundException(ItemNotFound itemNotFound){
        return new ResponseEntity<>(
                new StandardResponse(HttpStatus.NOT_FOUND.value(),
                "Empty Items List",
                itemNotFound.getMessage()
        ),HttpStatus.NOT_FOUND);
    }

}
