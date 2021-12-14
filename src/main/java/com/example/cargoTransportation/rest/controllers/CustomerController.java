package com.example.cargoTransportation.rest.controllers;


import com.example.cargoTransportation.models.Customer;
import com.example.cargoTransportation.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public Iterable<Customer>getAllCustomers(){
        return customerRepository.findAll();
    }

}
