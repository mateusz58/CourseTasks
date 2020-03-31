package com.kodilla.patterns2.facade.service;

import com.kodilla.patterns2.facade.api.ItemDto;
import com.kodilla.patterns2.facade.api.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Service
public class ShopService {

    @Builder.Default
    private List<OrderDto> orders = new ArrayList<>();

    private Authenticator authenticator;

    private ProductService productService;

    @Autowired
    public ShopService(Authenticator authenticator, ProductService productService) {
        this.authenticator = authenticator;
        this.productService = productService;
    }

    public BigDecimal calculateValue(Long orderId) {
        Iterator<OrderDto> orderIterator = orders.stream()
                .filter(o -> o.getId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            OrderDto theOrder = orderIterator.next();
            return theOrder.calculateSum();
        }
        return BigDecimal.ZERO;
    }

    public Long openOrder(Long userId) {
        if(authenticator.isAuthenticated(userId)) {
            Long maxOrder = (long)orders.stream()
                    .mapToLong(o -> o.getId().longValue())
                    .max().orElse(0);
            orders.add(OrderDto.builder().id(maxOrder).userId(userId).productService(productService).build());
            return maxOrder +1;
        }
        return -1L;
    }

    public void addItem(Long orderId, Long productId, int quantity) {
        orders.stream()
                .filter(o -> o.getId().equals(orderId))
                .forEach(o -> o.getItemList().add(ItemDto.builder().productId(productId).quantity(quantity).build()));
    }

    public boolean removeItem(Long orderId, Long productId) {
        Iterator<OrderDto> orderIterator = orders.stream()
                .filter(order -> order.getId().equals(orderId)).iterator();

        while(orderIterator.hasNext()) {
            OrderDto order = orderIterator.next();
            int orderSize = order.getItemList().size();
            for (int i = 0; i < orderSize; i++) {
                if(order.getItemList().get(i).getProductId().equals(productId)) {
                    order.getItemList().remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean doPayment(Long orderId) {
        Iterator<OrderDto> orderIterator = orders.stream()
                .filter(order -> order.getId().equals(orderId)).iterator();
        while(orderIterator.hasNext()) {
            OrderDto theOrder = orderIterator.next();
            if(theOrder.isPaid()) {
                return true;
            } else {
                Random random = new Random();
                theOrder.setPaid(random.nextBoolean());
                return theOrder.isPaid();
            }
        }
        return false;
    }

    public boolean submitOrder(Long orderId) {
        Iterator<OrderDto> orderIterator = orders.stream()
                .filter(o -> o.getId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            OrderDto theOrder = orderIterator.next();
            boolean result = theOrder.isPaid();
            Random generator = new Random();
            if (theOrder.isVerified()) {
                theOrder.setSubmitted(true);
            }
            return theOrder.isSubmitted();
        }
        return false;
    }

    public void cancelOrder(Long orderId) {
        Iterator<OrderDto> orderIterator = orders.stream()
                .filter(o -> o.getId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            OrderDto theOrder = orderIterator.next();
            orders.remove(theOrder);
        }
    }

    public boolean verifyOrder(Long orderId) {
        Iterator<OrderDto> orderIterator = orders.stream()
                .filter(o -> o.getId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            OrderDto theOrder = orderIterator.next();
            boolean result = theOrder.isPaid();
            Random generator = new Random();
            if (!theOrder.isVerified()) {
                theOrder.setVerified(result && generator.nextBoolean());
            }
            return theOrder.isVerified();
        }
        return false;
    }
}
