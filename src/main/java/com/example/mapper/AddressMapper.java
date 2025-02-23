package com.example.mapper;

import com.example.dto.AddressDto;
import com.example.model.AddressModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "country", source = "country")
    AddressDto toDto(AddressModel addressModel);

    @Mapping(target = "country", source = "country")
    AddressModel toEntity(AddressDto addressDto);
}
