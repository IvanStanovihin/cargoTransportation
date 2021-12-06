package com.example.cargoTransportation.controllers;


import com.example.cargoTransportation.models.Customer;
import com.example.cargoTransportation.models.Place;
import com.example.cargoTransportation.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Customer customer = customerRepository.findById(id).get();
        model.addAttribute("customer", customer);
        return "customers/show";
    }

    @GetMapping("/new")
    public String newPlace(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customers/new";
    }

    @PostMapping()
    public String createPlace(@ModelAttribute Customer customer, Model model) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        Customer customerForEdit = customerRepository.findById(id).get();
        model.addAttribute("customer", customerForEdit);
        return "customers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("customer") Customer customer, @PathVariable("id") int id) {
        Customer customerForUpdate = customerRepository.findById(id).get();
        customerForUpdate.setName(customer.getName());
        customerForUpdate.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(customerForUpdate);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);
        return "redirect:/customers";
    }

}
