package com.springboot.academy.pointofsale.exceptions.haddlers;

//import com.springboot.academy.pointofsale.exceptions.CustomerNotFoundException;
//import com.springboot.academy.pointofsale.util.StandardResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
//public class CustomExceptionHandler {
//
//    @ExceptionHandler(CustomerNotFoundException.class)
//    public ResponseEntity<StandardResponse> handleCustomerNotFound(CustomerNotFoundException exception) {
//        StandardResponse response = new StandardResponse(
//                HttpStatus.NOT_FOUND.value(),
//                "Customer Not Found",
//                exception.getMessage()
//        );
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<StandardResponse> handleGenericException(Exception exception) {
//        StandardResponse response = new StandardResponse(
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                "Internal Server Error",
//                exception.getMessage()
//        );
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//
//}
