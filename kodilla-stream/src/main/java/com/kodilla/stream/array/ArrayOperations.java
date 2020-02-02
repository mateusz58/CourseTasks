package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length - 1)
            .forEach(i -> System.out.println(numbers[ i ]));
        return IntStream.of(numbers)
            .average()
            .getAsDouble();
    }
}
