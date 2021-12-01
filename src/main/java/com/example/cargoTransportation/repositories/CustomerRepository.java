package com.example.cargoTransportation.repositories;

import com.example.cargoTransportation.models.Customer;
import com.example.cargoTransportation.models.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
