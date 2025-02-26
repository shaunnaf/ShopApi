package com.example.service;

import com.example.dto.AddressDto;
import com.example.dto.ClientDto;
import com.example.mapper.ClientMapper;
import com.example.model.AddressModel;
import com.example.model.ClientModel;
import com.example.repository.AddressRepository;
import com.example.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final AddressRepository addressRepository;

    public List<ClientDto> getAllClients(Integer limit, Integer offset) {
        List<ClientModel> clientModels;
        if (limit != null && offset != null) {
            Pageable pageable = PageRequest.of(offset, limit);
            clientModels = clientRepository.findAll(pageable).getContent();
        } else {
            clientModels = clientRepository.findAll();
        }
        return clientModels.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDto saveClient(ClientDto clientDto) {
        ClientModel clientModel = clientMapper.toEntity(clientDto);

        AddressModel addressModel = addressRepository.findById(clientDto.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        clientModel.setAddress(addressModel);
        clientModel = clientRepository.save(clientModel);

        return clientMapper.toDto(clientModel);
    }

    public void deleteClient(UUID id) {
        clientRepository.deleteById(id);
    }

    public List<ClientDto> getClientByNameAndSurname(String name, String surname) {
        List<ClientModel> clientModels = clientRepository.findByClientNameAndClientSurname(name, surname);
        return clientModels.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    public ClientDto updateAddress(AddressDto addressDto) {
        ClientModel clientModel = clientRepository.findById(addressDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден."));
        AddressModel addressModel = addressRepository.findById(clientModel.getAddress().getId())
                .orElseThrow(() -> new EntityNotFoundException("Адрес не найден."));
        addressModel.setCity(addressDto.getCity());
        addressModel.setCountry(addressDto.getCountry());
        addressModel.setStreet(addressDto.getStreet());

        addressRepository.save(addressModel);
        return clientMapper.toDto(clientModel);

    }
}
