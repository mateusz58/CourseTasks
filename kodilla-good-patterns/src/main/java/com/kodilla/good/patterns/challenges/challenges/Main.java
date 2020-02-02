package com.kodilla.good.patterns.challenges.challenges;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(MovieStore.getMovies().entrySet()
            .stream()
            .flatMap(s ->s.getValue().stream())
            .collect(Collectors.joining("!")));
    }
}
