package com.example.cargoTransportation.logic.graphHopper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphHopperService {

    private List<List<String>> addresses = new ArrayList<>();

    {
        List<String>address1 = Stream.of("Лермонтова 1", "Румянцева 19").collect(Collectors.toList());
        List<String>address2 = Stream.of("Чкалова 15", "Декабрьских Событий 3").collect(Collectors.toList());
        List<String>address3 = Stream.of("Румянцева 28", "Степана Разина 6").collect(Collectors.toList());
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
    }


}
