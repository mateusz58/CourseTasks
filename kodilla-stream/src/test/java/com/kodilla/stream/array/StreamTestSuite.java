package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTestSuite {


    @Test
    void test() {
        //Given
        int[] given = new int[] {1, 2, 3, 4, 5, 6};

        //When
        double expected = 3.5;
        double actual = ArrayOperations.getAverage(new int[] {1, 2, 3, 4, 5, 6});

        //Then
        assertEquals(expected, actual);
    }
}
