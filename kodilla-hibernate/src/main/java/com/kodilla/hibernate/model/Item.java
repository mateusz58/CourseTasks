package com.kodilla.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Item {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;

    @ManyToOne(targetEntity = Invoice.class)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    private Invoice invoice;
}
