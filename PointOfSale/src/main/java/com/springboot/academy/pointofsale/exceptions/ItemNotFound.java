package com.springboot.academy.pointofsale.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFound extends RuntimeException{

    public ItemNotFound(String message) {
        super(message);
    }
}
