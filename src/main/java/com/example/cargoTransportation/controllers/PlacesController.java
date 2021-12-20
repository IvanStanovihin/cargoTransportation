package com.example.cargoTransportation.controllers;

import com.example.cargoTransportation.logic.service.PlaceService;
import com.example.cargoTransportation.models.Customer;
import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.models.Place;
import com.example.cargoTransportation.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/places")
public class PlacesController {


    private PlaceRepository placeRepository;
    private PlaceService placeService;

    @Autowired
    public PlacesController(PlaceRepository placeRepository, PlaceService placeService){
        this.placeRepository = placeRepository;
        this.placeService = placeService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("places", placeRepository.findAll());
        return "places/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Place place = placeRepository.findById(id).get();
        model.addAttribute("place", place);
        return "places/show";
    }

    @GetMapping("/new")
    public String newPlace(Model model) {
        Place place = new Place();
        model.addAttribute("place", place);
        return "places/new";
    }

    @PostMapping()
    public String createPlace(@ModelAttribute Place place, Model model) {
        placeService.geocoding(place);
        placeRepository.save(place);
        return "redirect:/places";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        Place place = placeRepository.findById(id).get();
        model.addAttribute("place", place);
        return "places/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("place") Place place, @PathVariable("id") int id) {
        Place placeToUpdate = placeRepository.findById(id).get();
        placeToUpdate.setAddress(place.getAddress());
        placeRepository.save(placeToUpdate);
        return "redirect:/places";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        Place place = placeRepository.findById(id).get();
        placeRepository.delete(place);
        return "redirect:/places";
    }
}
