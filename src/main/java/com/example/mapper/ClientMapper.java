package com.example.mapper;

import com.example.dto.ClientDto;
import com.example.model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "clientName", source = "clientName")
    @Mapping(target = "addressId", source = "address.id")
    ClientDto toDto(ClientModel clientModel);

    @Mapping(target = "clientName", source = "clientName")
    @Mapping(target = "address.id", source = "addressId")
    ClientModel toEntity(ClientDto clientDto);

}
