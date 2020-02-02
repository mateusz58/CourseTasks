package com.kodilla.good.patterns.challenges.challenges.flightsSearcher;

import java.util.Set;

public class FlightsDb {
    private Set<Flight> availableFlights;

    public FlightsDb(Set<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public FlightsDb() {
    }

    public Set<Flight> getAvailableFlights() {
        return availableFlights;
    }
}
