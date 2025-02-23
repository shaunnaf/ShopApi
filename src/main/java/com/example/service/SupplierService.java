package com.example.service;


import com.example.dto.AddressDto;
import com.example.dto.SupplierDto;
import com.example.mapper.SupplierMapper;
import com.example.model.AddressModel;
import com.example.model.SupplierModel;
import com.example.repository.AddressRepository;
import com.example.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    private final AddressRepository addressRepository;

    public List<SupplierDto> getAllSupplier() {
        List<SupplierModel> supplierModels = supplierRepository.findAll();
        return supplierModels.stream()
                .map(supplierMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteByIdSupplier(UUID id) {
        supplierRepository.deleteById(id);
    }

    public SupplierDto getByIdSupplier(UUID id) {
        return supplierMapper.toDto(supplierRepository.getReferenceById(id));
    }

    public SupplierDto addSupplier(SupplierDto supplierDto) {
        return supplierMapper.toDto(supplierRepository.save(supplierMapper.toEntity(supplierDto)));
    }

    public SupplierDto updateAddressSuppllier(AddressDto addressDto) {
        SupplierModel supplierModel = supplierRepository.findById(addressDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
        AddressModel addressModel = addressRepository.findById(supplierModel.getAddress().getId())
                .orElseThrow(() -> new EntityNotFoundException("Адрес не найден"));
        addressModel.setStreet(addressDto.getStreet());
        addressModel.setCity(addressDto.getCity());
        addressModel.setCountry(addressDto.getCountry());

        addressRepository.save(addressModel);

        return supplierMapper.toDto(supplierModel);
    }
}
