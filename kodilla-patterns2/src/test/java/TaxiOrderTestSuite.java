import com.kodilla.patterns2.decorator.taxiportal.BasicTaxiOrder;
import com.kodilla.patterns2.decorator.taxiportal.TaxiOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxiOrderTestSuite {

    @Test
    void testBasicTaxiOrderTestSuite() {
        //given
        TaxiOrder order = new BasicTaxiOrder();

        //when
        BigDecimal calculateCost = order.getCost();

        //then
        assertEquals(new BigDecimal(5), calculateCost);
    }

    @Test
    void testBasicTaxiOrdergetDescription() {
        //given
        TaxiOrder order = new BasicTaxiOrder();

        //when
        String description = order.getDescription();

        //then
        assertEquals("Drive a course", description);
    }

}
