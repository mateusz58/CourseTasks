package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public abstract class TaxiNetworkOrderDecorator extends AbstractTaxiOrderDecorator {

    public TaxiNetworkOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(35));
    }

    public String getDescription() {
        return super.getDescription() + "by Taxi Network";
    }
}
