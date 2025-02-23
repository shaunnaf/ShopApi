package com.example.service;

import com.example.dto.ProductDto;
import com.example.mapper.ProductMapper;
import com.example.model.ProductModel;
import com.example.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getAllProduct() {
        List<ProductModel> productModels = productRepository.findAll();
        return productModels.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    public ProductDto getProduct(UUID id) {
        return productMapper.toDto(productRepository.getReferenceById(id));
    }

    public ProductDto decrementAvailableStock(UUID id, int count) {
        ProductModel productModel = productRepository.getReferenceById(id);
        productModel.setAvailableStock(productModel.getAvailableStock() - count);
        return productMapper.toDto(productModel);
    }

    public ProductDto addProduct(ProductDto productDto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }
}
