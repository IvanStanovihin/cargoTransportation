package com.example.cargoTransportation.rest.controllers;


import com.example.cargoTransportation.models.Car;
import com.example.cargoTransportation.repositories.CarRepository;
import com.github.dockerjava.zerodep.shaded.org.apache.hc.core5.http.HttpResponse;
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

   @PostMapping("/insert")
    public Iterable<Car> insertCar(@RequestBody Car car){
       carRepository.save(car);
       return carRepository.findAll();
   }

   @GetMapping("{id}")
    public Car getOneCar(@PathVariable String id){
       Car foundCar = carRepository.findById(Integer.parseInt(id)).get();
       return foundCar;
   }

   @PostMapping
    public Iterable<Car> createCar(@RequestBody Car newCar){
       carRepository.save(newCar);
       return carRepository.findAll();
   }


   @PutMapping("{id}")
    public Car updateCar(@PathVariable String id, @RequestBody Car carForUpdate){
       Car carFromDB = carRepository.findById(Integer.parseInt(id)).get();
       carFromDB.setCapacity(carForUpdate.getCapacity());
       carFromDB.setModel(carForUpdate.getModel());
       carRepository.save(carFromDB);
       return carFromDB;
   }


   @DeleteMapping("{id}")
    public void deleteCar(@PathVariable String id){
       carRepository.deleteById(Integer.parseInt(id));
   }
}
