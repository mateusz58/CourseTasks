package com.kodilla.good.patterns.challenges.challenges.food2Door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRetriever {

    public List<OrderRequest> retrieve() {
        List<OrderRequest> orderRequestList = new ArrayList<>();

        Customer customer = new Customer("JohnDoe");
        FoodProducer foodProducer = new GlutenFreeShop();
        Map<Product, Integer> productsList = new HashMap<>();
        productsList.put(new GlutenFreeProduct("bread", "Bread made from coconut flour"), 2);
        productsList.put(new GlutenFreeProduct("rice", "extraordinary white rice"), 3);
        productsList.put(new GlutenFreeProduct("cookies", "amaranth cookies with dactyls"), 1000);

        orderRequestList.add(new OrderRequest(customer, foodProducer, productsList));

        Customer customer1 = new Customer("Malcolm");
        FoodProducer foodProducer1 = new GlutenFreeShop();
        Map<Product, Integer> productsList1 = new HashMap<>();
        productsList.put(new GlutenFreeProduct("bread", "Bread made from coconut flour"), 2);
        productsList.put(new GlutenFreeProduct("rice", "extraordinary white rice"), 3);
        productsList.put(new GlutenFreeProduct("cookies", "amaranth cookies with dactyls"), 1);

        orderRequestList.add(new OrderRequest(customer1, foodProducer1, productsList1));

        return orderRequestList;
    }
}
