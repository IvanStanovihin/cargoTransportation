package com.example.cargoTransportation.rest.controllers;

import com.example.cargoTransportation.models.Place;
import com.example.cargoTransportation.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping
    public Iterable<Place>getAllPlaces(){
        return placeRepository.findAll();
    }
}
