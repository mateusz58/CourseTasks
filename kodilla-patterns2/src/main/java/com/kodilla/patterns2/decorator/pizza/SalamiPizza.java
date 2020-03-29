package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;

public class SalamiPizza extends AbstractPizzaDecorator {

    public SalamiPizza(PizzaI pizzaI) {
        super(pizzaI);
    }

    @Override
    public BigDecimal calculateCost() {
        return super.calculateCost().add(BigDecimal.valueOf(10.00));
    }

    @Override
    public List<String> getIngredients() {
        List<String> list = super.getIngredients();
        list.add("Salami");
        return list;
    }
}
