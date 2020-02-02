package com.kodilla.hibernate.invoices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kodilla.hibernate.dao.InvoiceDao;
import com.kodilla.hibernate.generators.NumberGenerator;
import com.kodilla.hibernate.generators.WordGenerator;
import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InvoiceDaoTestSuite {

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
            items.add(Item.Builder.anItem()
                .withPrice(BigDecimal.valueOf(NumberGenerator.generateRandomNumber(2)))
                .withQuantity(10)
                .withValue(BigDecimal.valueOf(10))
                .withProduct(Product.Builder.aProduct().withName(WordGenerator.generateRandomWord()).build())
                .build());

        }
        invoice = Invoice.Builder.anInvoice()
            .withItems(items)
            .withNumber(WordGenerator.generateRandomWord())
            .build();
    }
}
