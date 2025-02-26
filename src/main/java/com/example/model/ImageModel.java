package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "images_model")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel {
    @Id
    private UUID id;

    @Lob
    @Column(columnDefinition = "bytea", nullable = true)
    private byte[] image;
}

