package com.example.cargoTransportation.repositories;

import com.example.cargoTransportation.models.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {

}
