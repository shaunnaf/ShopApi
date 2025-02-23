package com.example.dto;

import com.example.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierDto {
    private UUID id;
    private String name;
    private UUID addressId;
    private String phoneNumber;
}
