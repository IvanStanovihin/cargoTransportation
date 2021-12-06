package com.example.cargoTransportation.repositories;


import com.example.cargoTransportation.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
