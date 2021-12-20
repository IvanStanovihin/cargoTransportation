package com.example.cargoTransportation;

import com.example.cargoTransportation.logic.maps.Geocoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CargoTransportationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CargoTransportationApplication.class, args);
		String coordinates = Geocoder.getCoordinates("Россия, Иркутск, улица Ленина, 1");
		System.out.println(coordinates);

	}

}
