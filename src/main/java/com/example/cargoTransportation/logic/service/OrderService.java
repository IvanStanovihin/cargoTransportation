package com.example.cargoTransportation.logic.service;

import com.example.cargoTransportation.logic.maps.Geocoder;
import com.example.cargoTransportation.models.Customer;
import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.models.Place;
import com.example.cargoTransportation.repositories.CustomerRepository;
import com.example.cargoTransportation.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    CustomerRepository customerRepository;


    public OrderItem createOrder(OrderItem orderItem){
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
        if (place == null || customer == null){
            return null;
        }else{
            orderItem.setCustomer(customer);
            orderItem.setPlace(place);
            orderItem.setStatus(false);
            orderItem.setCreationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
            return orderItem;
        }
    }






}
