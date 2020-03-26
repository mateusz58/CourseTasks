package com.kodilla.good.patterns.challenges.challenges.flightsSearcher;

import com.kodilla.good.patterns.challenges.challenges.MovieStore;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Flight flight1 = new Flight("AirportDeparture", "ArrivalAirport");
        Flight flight2 = new Flight("AirportDeparture2", "ArrivalAirport2");
        Flight flight3 = new Flight("ArrivalAirport", "AirportDeparture");
        FlightsDb flightsDb = new FlightsDb(new HashSet<Flight>(Arrays.asList(flight1,flight2)));

        FlightsService flightsService = new FlightsService(flightsDb);

        flightsService.availableFlightsTo("ArrivalAirport").stream().forEach(s-> System.out.println(s.getArrivalAirport()+s.getDepartureAirport()));
        System.out.println("\n");

        flightsService.availableFlightsFrom("AirportDeparture").stream().forEach(s-> System.out.println(s.getArrivalAirport()+s.getDepartureAirport()));

        System.out.println("\n");
        flightsService.availableConnectingFlights("AirportDeparture", "ArrivalAirport").stream().forEach(s-> System.out.println(s.getArrivalAirport()+s.getDepartureAirport()));
    }
}