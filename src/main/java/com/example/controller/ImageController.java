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
  /*  private final ImageService imageService;
    private final ImageMapper imageMapper;
    private final ImageRepository imageRepository;

    @PostMapping(value = "/add/{productId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImageDto> addImage(
            @PathVariable UUID productId,
            @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(imageService.addImage(productId, file));
    }

    @PostMapping("/addImage")
    public ResponseEntity<ImageDto> addImage(@RequestParam("file") MultipartFile file) throws IOException {
        ImageModel image = new ImageModel();
        image.setImage(file.getBytes());

        image = imageRepository.save(image);
        return ResponseEntity.ok(imageMapper.toDto(image));
    }

    @PutMapping(value = "/update/{imageId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImageDto> updateImage(
            @PathVariable UUID imageId,
            @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(imageService.updateImage(imageId, file));
    }

    @DeleteMapping("/delete/{imageId}")
    public ResponseEntity<Void> deleteImage(@PathVariable UUID imageId) {
        imageService.deleteImageById(imageId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{imageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImageById(@PathVariable UUID imageId) {
        ImageDto imageDto = imageService.getImageById(imageId);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageDto.getImage());
    }

   */
}
