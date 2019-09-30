package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {

    private final String name;

    private BigDecimal peopleQuantity;

    public Country(String name,BigDecimal peopleQuantity) {
        this.name=name;
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }

    public String getName() {
        return name;
    }
}
