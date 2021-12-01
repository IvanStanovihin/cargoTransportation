package com.example.cargoTransportation.repositories;

import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.models.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlaceRepository extends CrudRepository<Place, Integer> {


}
