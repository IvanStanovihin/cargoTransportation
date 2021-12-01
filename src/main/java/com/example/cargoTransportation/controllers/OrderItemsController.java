package com.example.cargoTransportation.controllers;

import com.example.cargoTransportation.models.Customer;
import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.models.Place;
import com.example.cargoTransportation.repositories.CustomerRepository;
import com.example.cargoTransportation.repositories.OrderItemRepository;
import com.example.cargoTransportation.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/orderItems")
public class OrderItemsController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/test")
    public String test() {
        return "orderItems/test";
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("orderItems", orderItemRepository.findAll());
        return "orderItems/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        OrderItem orderItem = orderItemRepository.findById(id).get();
        model.addAttribute("orderItem", orderItem);
        return "orderItems/show";
    }

    @GetMapping("/new")
    public String newOrderItem(Model model) {
        OrderItem orderItem = new OrderItem();
        model.addAttribute("orderItem", orderItem);
        return "orderItems/new";
    }

    @PostMapping()
    public String createOrderItem(@ModelAttribute OrderItem orderItem, Model model) {
        Customer customer = null;
        Place place = null;
        Integer customerId = orderItem.getCustomer().getId();
        Optional<Customer> customerOp = customerRepository.findById(customerId);
        if (customerOp.isPresent()) {
            customer = customerOp.get();
        }

        Integer placeId = orderItem.getPlace().getId();
        Optional<Place> placeOp = placeRepository.findById(placeId);
        if (placeOp.isPresent()) {
            place = placeOp.get();
        }

        if (customer == null || place == null) {
            return "redirect:/orderItems/new";
        } else {
            orderItem.setCustomer(customer);
            orderItem.setPlace(place);
            orderItemRepository.save(orderItem);
            return "redirect:/orderItems";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        OrderItem order = orderItemRepository.findById(id).get();
        model.addAttribute("orderItem", order);
        return "orderItems/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("orderItem") OrderItem orderItem, @PathVariable("id") int id) {
        OrderItem orderToUpdate = orderItemRepository.findById(orderItem.getId()).get();
        orderToUpdate.setCargoWeight(orderItem.getCargoWeight());
        orderToUpdate.setCreationDate(orderItem.getCreationDate());
        orderToUpdate.setNote(orderItem.getNote());
        orderToUpdate.setStatus(orderItem.getStatus());
        orderItemRepository.save(orderToUpdate);
        return "redirect:/orderItems";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        OrderItem orderToDelete = orderItemRepository.findById(id).get();
        orderItemRepository.delete(orderToDelete);
        return "redirect:/orderItems";
    }

}
