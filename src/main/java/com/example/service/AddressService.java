package com.example.service;

import com.example.dto.AddressDto;
import com.example.mapper.AddressMapper;
import com.example.model.AddressModel;
import com.example.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressDto addAddress(AddressDto addressDto) {
        AddressModel addressModel = addressMapper.toEntity(addressDto);
        addressModel = addressRepository.save(addressModel);
        return addressMapper.toDto(addressModel);
    }

    public List<AddressDto> getAll() {
        List<AddressModel> addressModels = addressRepository.findAll();
        return addressModels.stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }
}
