package com.example.mapper;

import com.example.dto.SupplierDto;
import com.example.model.SupplierModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "addressId", source = "address.id")
    SupplierDto toDto(SupplierModel supplierModel);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "address.id", source = "addressId")
    SupplierModel toEntity(SupplierDto supplierDto);
}
