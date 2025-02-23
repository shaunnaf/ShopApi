package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "client_model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String clientName;
    private String clientSurname;
    private LocalDate birthday;
    private String gender;
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)  // Внешний ключ!
    private AddressModel address;
}
