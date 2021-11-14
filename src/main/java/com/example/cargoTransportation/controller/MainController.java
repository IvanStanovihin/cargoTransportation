package com.example.cargoTransportation.controller;

import com.example.cargoTransportation.logic.utils.DateConverter;
import com.example.cargoTransportation.models.Order;
import com.example.cargoTransportation.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private OrderRepo orderRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name ="name", required=false, defaultValue="Operator") String name,
                           Map<String, Object> model){
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Order>orders = orderRepository.findAll();
        model.put("orders", orders);
        return "main";
    }

    @PostMapping
    public String addOrder(@RequestParam Integer idCustomer, @RequestParam Integer idPlace,
                           @RequestParam Integer cargoWeight, @RequestParam String note, Map<String, Object> model){
        String creationOrderDate = DateConverter.getOrderDate();
        Order requestOrder = new Order(idCustomer, idPlace, cargoWeight, note, creationOrderDate);
        orderRepository.save(requestOrder);

        Iterable<Order>orders = orderRepository.findAll();
        model.put("orders", orders);
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String orderCreationDate, Map<String, Object> model){
        List<Order>filteredOrders = orderRepository.findByCreationDate(orderCreationDate);
        model.put("orders", filteredOrders);
        return "main";
    }
}
