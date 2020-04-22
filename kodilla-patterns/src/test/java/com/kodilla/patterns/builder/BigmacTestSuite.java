package com.kodilla.patterns.builder;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    public void testBigMacNew() {
        //Given
        BigMac bigMac = new BigMac.BigmacBuilder()
                        .roll("with sesame")
                        .burgers(1)
                        .ingredients( new ArrayList<>(Arrays.asList("ingredient1", "ingredient2")))
                        .build();

        //When
        int howManyIngredients = bigMac.getIngredients().size();
        int howManyBurgers = bigMac.getBurgers();

        //Then
        assertEquals(2, howManyIngredients);
        assertEquals(1, howManyBurgers);
    }
}
