package com.kodilla.patterns.Generators;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerator {

    public static int generateRandomNumber(int length) {
        int size = (int) Math.pow(10, length);

        return ThreadLocalRandom.current().nextInt(size/10,size-1);
    }

}
