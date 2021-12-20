package com.example.cargoTransportation.logic.service;

import com.example.cargoTransportation.logic.maps.Geocoder;
import com.example.cargoTransportation.models.OrderItem;
import com.example.cargoTransportation.models.Place;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {

    public void geocoding(Place place) {
        String orderAddress = place.getAddress();
        String addressCoordinates = Geocoder.getCoordinates(orderAddress);
        String[] coordinates = addressCoordinates.split(",");
        place.setLatitude(Double.parseDouble(coordinates[0]));
        place.setLongitude(Double.parseDouble(coordinates[1]));
    }

}
