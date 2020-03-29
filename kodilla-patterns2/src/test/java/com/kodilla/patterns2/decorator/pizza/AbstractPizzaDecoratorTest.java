package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPizzaDecoratorTest {

    PizzaI pizzaI;

    @BeforeEach
    void setup() {
        pizzaI = new PizzaBasic();
    }

    @Test
    void testCalculateCostForSalamiPizza() {
        //Given
        pizzaI = new SalamiPizza(pizzaI);

        //When
        BigDecimal totalCostOfSalami = pizzaI.calculateCost();

        assertEquals(pizzaI.calculateCost(),BigDecimal.valueOf(25.0));
    }

    @Test
    void testCheckIgredients() {
        //Given
        List<String> expected = Arrays.asList("ciasto","ser","sos","Salami");
        pizzaI = new SalamiPizza(pizzaI);

        //When
        List<String> given = pizzaI.getIngredients();

        assertEquals(expected, given);
    }
}