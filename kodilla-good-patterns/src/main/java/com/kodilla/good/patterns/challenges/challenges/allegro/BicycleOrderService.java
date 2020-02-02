package com.kodilla.good.patterns.challenges.challenges.allegro;

import java.time.LocalDateTime;
import java.util.Random;

public class BicycleOrderService implements ProductOrderService {
    @Override
    public boolean sold(User user, LocalDateTime orderDate, Product product, int quantity) {
        return new Random().nextBoolean();
    }
}
