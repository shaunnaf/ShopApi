package com.example.mapper;

import com.example.dto.ImageDto;
import com.example.model.ImageModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageDto toDto(ImageModel imageModel);

    ImageModel toEntity(ImageDto imageDto);
}
