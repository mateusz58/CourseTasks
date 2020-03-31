package com.kodilla.patterns2.facade.service;

import com.kodilla.patterns2.facade.api.OrderFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class OrderFacadeTest {

    @Autowired
    private OrderFacade orderFacade;

    @Autowired
    private ShopService shopService;

    @Test
    void testSubmitOrder() throws Exception {
        //Given

    }

    @Test
    void processOrder() {
    }
}