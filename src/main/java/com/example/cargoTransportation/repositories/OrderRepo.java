package com.example.cargoTransportation.repositories;

import com.example.cargoTransportation.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Long> {

    List<Order> findByCreationDate(String creationDate);
}
