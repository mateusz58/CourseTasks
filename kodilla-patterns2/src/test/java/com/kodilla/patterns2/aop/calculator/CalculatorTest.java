package com.kodilla.patterns2.aop.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CalculatorTest {
    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd() {
        //Given
        //When
        double result = calculator.add(10, 15);
        //Then
        assertEquals(25, result);
    }
    @Test
    public void testSub() {
        //Given
        //When
        double result = calculator.sub(10, 15);
        //Then
        assertEquals(-5, result);
    }
    @Test
    public void testMul() {
        //Given
        //When
        double result = calculator.mul(10, 15);
        //Then
        assertEquals(150, result);
    }
    @Test
    public void testDiv() {
        //Given
        //When
        double result = calculator.div(15, 5);
        //Then
        assertEquals(3, result);
    }

    @Test
    public void testfactorial() {
       BigDecimal result = calculator.factorial(new BigDecimal("1000"));

       //then

    }
}