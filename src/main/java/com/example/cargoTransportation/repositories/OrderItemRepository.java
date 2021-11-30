package com.example.cargoTransportation.repositories;

import com.example.cargoTransportation.models.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

    List<OrderItem> findByCreationDate(String creationDate);
}
