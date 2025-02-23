package com.example.mapper;

import com.example.dto.ImageDto;
import com.example.model.ImageModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageDto toDto(ImageModel imageModel);

    ImageModel toEntity(ImageDto imageDto);
}
