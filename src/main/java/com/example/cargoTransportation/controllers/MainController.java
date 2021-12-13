package com.example.cargoTransportation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mainForm")
public class MainController {

    @GetMapping()
    public String mainForm(Model model){
        return "mainForm/mainView";
    }

    @GetMapping("testIndex")
    public String testIndex(Model model){
        return "misha/index";
    }

}
