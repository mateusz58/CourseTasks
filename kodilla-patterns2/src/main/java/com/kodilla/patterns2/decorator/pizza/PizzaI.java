package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;

public interface PizzaI {

    BigDecimal calculateCost();

    List<String> getIngredients();
}
