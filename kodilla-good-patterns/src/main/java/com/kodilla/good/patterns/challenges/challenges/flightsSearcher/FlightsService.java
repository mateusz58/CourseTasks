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

    public Set<List<Flight>> availableConnectingFlights(String departureAirport, String arrivalAirport) {
        Set<List<Flight>> setOfFlights = new HashSet<>();

        flightsDb.getAvailableFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .forEach(flight -> {
                    List <Flight> temp = flightsDb.getAvailableFlights().stream()
                            .filter(fl -> (flight.getArrivalAirport().equals(fl.getDepartureAirport()) && fl.getArrivalAirport().equals(arrivalAirport)))
                            .collect(Collectors.toList());

                    if (temp.size() > 0) {
                        List<Flight> flightsRoute = new ArrayList<>();
                        flightsRoute.add(flight);
                        flightsRoute.addAll(temp);
                        setOfFlights.add(flightsRoute);
                    }
                });
        return setOfFlights;
    }
}
