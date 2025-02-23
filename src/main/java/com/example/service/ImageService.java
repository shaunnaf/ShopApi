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
   /* private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public ImageDto addImage(UUID productId, MultipartFile file) throws IOException {
        ImageModel imageModel = new ImageModel();
        imageModel.setImage(file.getBytes());

        ImageModel savedImage = imageRepository.save(imageModel);
        return imageMapper.toDto(savedImage);
    }

    public ImageDto updateImage(UUID imageId, MultipartFile file) throws IOException {
        Optional<ImageModel> optionalImage = imageRepository.findById(imageId);
        if (optionalImage.isPresent()) {
            ImageModel imageModel = optionalImage.get();
            imageModel.setImage(file.getBytes());
            ImageModel updatedImage = imageRepository.save(imageModel);
            return imageMapper.toDto(updatedImage);
        }
        throw new RuntimeException("Image not found");
    }

    public void deleteImageById(UUID id) {
        if (!imageRepository.existsById(id)) {
            throw new RuntimeException("Image not found");
        }
        imageRepository.deleteById(id);
    }

    public ImageDto getImageById(UUID imageId) {
        ImageModel imageModel = imageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        return imageMapper.toDto(imageModel);
    }

    */
}
