package com.kodilla.patterns2.facade.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemDto {

    private  Long productId;
    private  int quantity;
}
