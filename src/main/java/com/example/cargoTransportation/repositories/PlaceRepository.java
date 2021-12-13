package com.example.cargoTransportation.repositories;

import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.models.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {


}
