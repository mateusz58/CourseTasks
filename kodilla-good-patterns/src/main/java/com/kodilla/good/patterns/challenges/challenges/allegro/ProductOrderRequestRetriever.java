package com.kodilla.good.patterns.challenges.challenges.allegro;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductOrderRequestRetriever {

    public ProductOrderRequest retrieve() {
        User user = new User("John", "Jan", "Kowalski");
        LocalDateTime orderDate = LocalDateTime.of(2017, 5, 20, 21, 25);
        Product product = new Bicycle("BMX",
                "Kultowy rower",
                new BigDecimal("1000"));
        int quantity = 1;

        System.out.println("Retrieve product request:");
        System.out.println("User: " + user.getUserName() +
                " Date: " + orderDate + "\n" +
                product + ", quantity=" + quantity);
        return new ProductOrderRequest(user, orderDate, product, quantity);
    }
}
