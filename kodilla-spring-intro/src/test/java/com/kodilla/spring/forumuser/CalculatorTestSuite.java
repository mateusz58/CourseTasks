package com.kodilla.spring.calculator;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Calculator.class)
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addingResult = calculator.add(4, 7);
        double substractionResult = calculator.substract(10, 3);
        double multiplyResult = calculator.mul(4, 7);
        double divideResult = calculator.div(10, 2);

        //Then
        Assertions.assertEquals(11, addingResult, 0.01);
        Assertions.assertEquals(7, substractionResult, 0.01);
        Assertions.assertEquals(28, multiplyResult, 0.01);
        Assertions.assertEquals(5, divideResult, 0.01);
    }
}
