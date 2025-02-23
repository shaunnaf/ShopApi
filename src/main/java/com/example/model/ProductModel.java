package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "product_model")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String category;
    private double price;
    private int availableStock;
    private LocalDate lastUpdateDate;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = true)
    private ImageModel image; // Может быть null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private SupplierModel supplier;
}
