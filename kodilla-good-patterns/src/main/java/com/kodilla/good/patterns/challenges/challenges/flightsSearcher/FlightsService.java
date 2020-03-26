package com.kodilla.good.patterns.challenges.challenges.flightsSearcher;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsService {
    private FlightsDb flightsDb;

    public FlightsService(FlightsDb flightsDb) {
        this.flightsDb = flightsDb;
    }

    public Set<Flight> availableFlightsFrom(String departureAirport) {
        return flightsDb.getAvailableFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toSet());
    }

    public Set<Flight> availableFlightsTo(String arrivalAirport) {
        return flightsDb.getAvailableFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
    }

    public List<Flight> availableConnectingFlights(String departureAirport, String arrivalAirport) {
        List<Flight> list = new ArrayList<>();
        list = flightsDb.getAvailableFlights().stream().filter(s->s.getDepartureAirport().equals(departureAirport) && s.getArrivalAirport().equals(arrivalAirport)).collect(Collectors.toList());
        return list;
    }
}
