package com.example.cargoTransportation.controllers;

import com.example.cargoTransportation.logic.utils.DateConverter;
import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @GetMapping("/hello")
    public String greeting(Map<String, Object> model){
        return "greeting";
    }


    @GetMapping("/main")
    public String main(@RequestParam(required = false) String filter, Map<String, Object> model){
        Iterable<OrderItem>orders;
        if (filter != null && !filter.isEmpty()){
            orders = orderItemRepository.findByCreationDate(filter);
        }else{
            orders = orderItemRepository.findAll();
        }
        model.put("orders", orders);
        return "main";
    }

    @PostMapping("/main")
    public String addOrder(@RequestParam Integer idCustomer, @RequestParam Integer idPlace,
                           @RequestParam Integer cargoWeight, @RequestParam String note, Map<String, Object> model){
        String creationOrderDate = DateConverter.getOrderDate();
        OrderItem requestOrderItem = new OrderItem(idCustomer, idPlace, cargoWeight, note, creationOrderDate);
        orderItemRepository.save(requestOrderItem);

        Iterable<OrderItem>orders = orderItemRepository.findAll();
        model.put("orders", orders);
        return "main";
    }




}
