package com.example.cargoTransportation.controllers;

import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orderItems")
public class OrderItemsController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/test")
    public String test(){
        return "orderItems/test";
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("orderItems", orderItemRepository.findAll());
        return "orderItems/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        OrderItem orderItem = orderItemRepository.findById(id).get();
        model.addAttribute("orderItem", orderItem);
        return "orderItems/show";
    }




}
