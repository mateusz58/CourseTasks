package com.kodilla.patterns2.facade.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Builder
@Service
public class Authenticator {

    public boolean isAuthenticated(Long userId) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
