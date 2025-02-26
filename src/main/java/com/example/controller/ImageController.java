package com.example.controller;

import com.example.dto.ImageDto;
import com.example.mapper.ImageMapper;
import com.example.model.ImageModel;
import com.example.repository.ImageRepository;
import com.example.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    private final ImageMapper imageMapper;
    private final ImageRepository imageRepository;

    @PostMapping("/addImage")
    public ResponseEntity<ImageDto> addImage(@RequestParam("imageId") UUID imageId,
                                             @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(imageService.addImage(imageId, file));
    }

    @DeleteMapping("/delete/{imageId}")
    public ResponseEntity<Void> deleteImage(@PathVariable UUID imageId) {
        imageService.deleteImageById(imageId);
        return ResponseEntity.noContent().build();
    }

}
