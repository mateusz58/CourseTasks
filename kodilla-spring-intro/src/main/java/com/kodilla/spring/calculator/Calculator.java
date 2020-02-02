package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    Display display;

    public int add(int a, int b) {
        display.displayValue(a + b);
        return a + b;
    }

    public int substract(int a, int b) {
        display.displayValue(a - b);
        return a - b;
    }

    public int mul(int a, int b) {
        display.displayValue(a * b);
        return a * b;
    }

    public int div(int a, int b) {
        display.displayValue(a / b);
        return a / b;
    }
}
