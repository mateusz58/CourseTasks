package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractPizzaDecorator implements  PizzaI {

    private final PizzaI pizzaI;

    protected AbstractPizzaDecorator(PizzaI pizzaI) {
        this.pizzaI = pizzaI;
    }

    @Override
    public BigDecimal calculateCost() {
        return pizzaI.calculateCost();
    }

    @Override
    public List<String> getIngredients() {
        return pizzaI.getIngredients();
    }
}
