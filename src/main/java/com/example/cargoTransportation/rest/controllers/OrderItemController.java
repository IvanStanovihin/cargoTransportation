package com.example.cargoTransportation.rest.controllers;


import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping
    public Iterable<OrderItem> getOrderItems(){
        return orderItemRepository.findAll();
    }
}
