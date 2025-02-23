package com.example.mapper;

import com.example.dto.ProductDto;
import com.example.model.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "imageId", source = "image.id")
    @Mapping(target = "supplierId", source = "supplier.id")
    ProductDto toDto(ProductModel productModel);

    @Mapping(target = "image.id", source = "imageId")
    @Mapping(target = "supplier.id", source = "supplierId")
    ProductModel toEntity(ProductDto productDto);


}
