package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "supplier_model")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressModel address;
    private String phoneNumber;
}
