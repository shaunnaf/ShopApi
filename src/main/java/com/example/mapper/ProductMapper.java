package com.example.mapper;

import com.example.dto.ProductDto;
import com.example.model.ImageModel;
import com.example.model.ProductModel;
import com.example.model.SupplierModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mapping(target = "name", source = "name")
    @Mapping(target = "image.id", source = "imageId")
    @Mapping(target = "supplier.id", source = "supplierId")
    ProductDto toDto(ProductModel productModel);


    @Mapping(target = "name", source = "name")
    @Mapping(target = "imageId", source = "image.id")
    @Mapping(target = "supplierId", source = "supplier.id")
    ProductModel toEntity(ProductDto productDto);


}
