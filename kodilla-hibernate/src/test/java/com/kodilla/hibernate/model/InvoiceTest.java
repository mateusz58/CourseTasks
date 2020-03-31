package com.kodilla.hibernate.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kodilla.hibernate.dao.InvoiceDao;
import com.kodilla.generators.NumberGenerator;
import com.kodilla.generators.WordGenerator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class InvoiceTest {

    @Autowired
    InvoiceDao invoiceDao;

    Invoice invoice;
    List<Item> items;

    @AfterEach
    void tearDown() {
        invoiceDao.deleteAll();
    }

    @Test
    void shouldSaveInvoice() {
        //given
        Invoice given = invoice;

        //when
        Invoice actual  = invoiceDao.save(given);

        //then
        assertEquals(given,actual);
    }

    @BeforeEach
    void setUp() {
        items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            items.add(Item.builder().id(++i)
                    .price(BigDecimal.valueOf(NumberGenerator.generateRandomNumber(2)))
                    .quantity(10)
                    .value(BigDecimal.valueOf(10))
                    .product(Product.builder().name(WordGenerator.generateRandomWord()).build())
                    .build());
        }
        invoice = Invoice.builder()
                .items(items)
                .number(WordGenerator.generateRandomWord())
                .build();
    }
}
