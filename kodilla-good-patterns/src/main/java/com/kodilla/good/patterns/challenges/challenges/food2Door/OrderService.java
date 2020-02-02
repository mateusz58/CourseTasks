package com.kodilla.good.patterns.challenges.challenges.food2Door;

import java.util.List;

public class OrderService {

    public void processAllOrders(List<OrderRequest> orderRequest) {

        orderRequest.stream()
                .map(n -> {
                    System.out.println("We're processing your order " + n.getCustomer().getName());
                    return n.getFoodProducer().process(n.getCustomer(), n.getProductOrderRequest());
                })
                .forEach(t -> System.out.println("Order finished with success: " + t + "\n"));
    }
}
