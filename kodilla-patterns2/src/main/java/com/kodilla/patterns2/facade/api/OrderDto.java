package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDto {

    private ProductService productService;
    private Long id;
    private Long userId;
    private  Long productId;
    @Builder.Default
    private boolean isPaid = false;
    @Builder.Default
    private boolean isVerified = false;
    @Builder.Default
    private boolean isSubmitted = false;
    @Builder.Default
    private List<ItemDto> itemList = new ArrayList<>();

    public BigDecimal calculateSum() {
        return (BigDecimal) itemList.stream().map(item -> productService.getPrice(item.getProductId()).multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, (a,b) -> a.add(b));
    }
}
