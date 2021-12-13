package com.example.cargoTransportation.controllers;


import com.example.cargoTransportation.models.Customer;
import com.example.cargoTransportation.models.Driver;
import com.example.cargoTransportation.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("drivers")
public class DriversController {

    @Autowired
    DriverRepository driverRepository;


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("drivers", driverRepository.findAll());
        return "drivers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Driver driver = driverRepository.findById(id).get();
        model.addAttribute("driver", driver);
        return "drivers/show";
    }

    @GetMapping("/new")
    public String newPlace(Model model) {
        Driver driver = new Driver();
        model.addAttribute("driver", driver);
        return "drivers/new";
    }

    @PostMapping()
    public String createPlace(@ModelAttribute Driver driver, Model model) {
        driverRepository.save(driver);
        return "redirect:/drivers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        Driver driverForEdit = driverRepository.findById(id).get();
        model.addAttribute("driver", driverForEdit);
        return "drivers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("driver") Driver driver, @PathVariable("id") int id) {
        Driver driverForUpdate = driverRepository.findById(id).get();
        driverForUpdate.setFirstName(driver.getFirstName());
        driverForUpdate.setLastName(driver.getLastName());
        driverForUpdate.setPatronymic(driver.getPatronymic());
        driverForUpdate.setPhoneNumber(driver.getPhoneNumber());
        return "redirect:/drivers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        Driver driver = driverRepository.findById(id).get();
        driverRepository.delete(driver);
        return "redirect:/drivers";
    }
}
