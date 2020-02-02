package com.kodilla.good.patterns.challenges.challenges.food2Door;

public class Food2Door {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.processAllOrders(new OrderRetriever().retrieve());
    }
}
