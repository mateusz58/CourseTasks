package com.kodilla.hibernate.generators;

import java.util.Random;

public class NumberGenerator {

    private static Random random = new Random();

    public static long generateRandomNumber(int length) {
        return Long.valueOf(random.nextInt(100));
    }
}
