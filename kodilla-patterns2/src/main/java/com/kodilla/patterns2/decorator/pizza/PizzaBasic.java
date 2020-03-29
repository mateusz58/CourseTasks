package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaBasic implements  PizzaI {

    @Override
    public BigDecimal calculateCost() {
        return new BigDecimal(15.00);
    }

    @Override
    public List<String> getIngredients() {
        return new ArrayList<>((Arrays.asList("ciasto", "ser", "sos")));
    }
}
