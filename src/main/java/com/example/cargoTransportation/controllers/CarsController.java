package com.example.cargoTransportation.controllers;


import com.example.cargoTransportation.models.Car;
import com.example.cargoTransportation.models.Customer;
import com.example.cargoTransportation.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Car car = carRepository.findById(id).get();
        model.addAttribute("car", car);
        return "cars/show";
    }

    @GetMapping("/new")
    public String newPlace(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "cars/new";
    }

    @PostMapping()
    public String createPlace(@ModelAttribute Car car, Model model) {
        carRepository.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        Car car = carRepository.findById(id).get();
        model.addAttribute("car", car);
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") Car car, @PathVariable("id") int id) {
        Car carForUpdate = carRepository.findById(id).get();
        carForUpdate.setModel(car.getModel());
        carForUpdate.setCapacity(car.getCapacity());
        carRepository.save(carForUpdate);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        Car carForDelete = carRepository.findById(id).get();
        carRepository.delete(carForDelete);
        return "redirect:/cars";
    }

}
