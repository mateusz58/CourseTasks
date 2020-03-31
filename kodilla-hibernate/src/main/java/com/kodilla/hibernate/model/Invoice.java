package com.kodilla.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "invoices")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class Invoice {

    @Id
    @GeneratedValue
    private int id;
    private String number;

    @Builder.Default
    @OneToMany(mappedBy = "invoice", targetEntity = Item.class)
    private List<Item> items = new ArrayList<>();
}