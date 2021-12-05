package com.example.cargoTransportation.controllers;

import com.example.cargoTransportation.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/mainForm")
public class MainController {

    @GetMapping()
    public String mainForm(Model model){
        return "mainForm/mainView";
    }

}
