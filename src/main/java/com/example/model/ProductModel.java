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


    @OneToOne
    @JoinColumn(name = "image_id", nullable = false) // Внешний ключ
    private ImageModel image;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false) // Внешний ключ
    private SupplierModel supplier;


}
