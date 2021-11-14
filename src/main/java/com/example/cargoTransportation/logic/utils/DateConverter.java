package com.example.cargoTransportation.logic.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    private static DateTimeFormatter orderCreationFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public static String getOrderDate(){
        ZonedDateTime currentDate = ZonedDateTime.now();
        return currentDate.format(orderCreationFormat);
    }
}
