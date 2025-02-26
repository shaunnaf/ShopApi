package com.example.service;

import com.example.dto.ImageDto;
import com.example.mapper.ImageMapper;
import com.example.model.ImageModel;
import com.example.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public ImageDto addImage(UUID productId, MultipartFile file) throws IOException {
        ImageModel imageModel = new ImageModel();
        imageModel.setImage(file.getBytes());
        imageModel.setId(productId);

        imageModel = imageRepository.save(imageModel);
        return imageMapper.toDto(imageModel);
    }

    public void deleteImageById(UUID id) {
        if (!imageRepository.existsById(id)) {
            throw new RuntimeException("Image not found");
        }
        imageRepository.deleteById(id);
    }
}
