package com.example.springsecurity.controller;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin
public class AccountController {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    //@Secured("ROLE_USER")
    public String getAccount(){
        return "Hello Account";
    }
}
