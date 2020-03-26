package com.kodilla.exception.test;


public class Flight {
    private final String departureAirport;
     private final String arrivalAirport;
     private boolean isActive;


    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.isActive=true;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public boolean isActive() {
        return isActive;
    }
}
