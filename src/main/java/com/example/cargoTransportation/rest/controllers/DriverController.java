package com.example.cargoTransportation.rest.controllers;


import com.example.cargoTransportation.models.Driver;
import com.example.cargoTransportation.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping
    public Iterable<Driver>getAllDrivers(){
        return driverRepository.findAll();
    }

}
