package com.kodilla.patterns2.facade.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@AllArgsConstructor
@Data
@Builder
@Service
public class ProductService {

    public BigDecimal getPrice(Long productId) {
        Random random = new Random();
        return new BigDecimal(random.nextInt(100000) / 100);
    }
}
