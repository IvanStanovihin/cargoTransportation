package com.example.cargoTransportation.rest.controllers;


import com.example.cargoTransportation.models.Car;
import com.example.cargoTransportation.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

   @GetMapping
    public Iterable<Car> getAllCars(){
       return carRepository.findAll();
   }

}
