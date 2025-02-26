package com.example.controller;

import com.example.dto.ProductDto;
import com.example.mapper.ProductMapper;
import com.example.model.ProductModel;
import com.example.model.SupplierModel;
import com.example.repository.SupplierRepository;
import com.example.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Продукты", description = "Api для работы с продуктами")
public class ProductController {
    private final ProductService productService;
    private final SupplierRepository supplierRepository;
    private final ProductMapper productMapper;

    @GetMapping("getProductById/{id}")
    @Operation(summary = "Посмотреть продукт по id")
    public ResponseEntity<ProductDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("getAllProduct")
    @Operation(summary = "Посмотреть все продукты в виде списка")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping("addProduct")
    @Operation(summary = "Добавить новый продукт")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        ProductModel productModel = productMapper.toEntity(productDto);

        SupplierModel supplier = supplierRepository.findById(productDto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        productModel.setSupplier(supplier);

        ProductModel savedProduct = productService.addProduct(productModel);
        return ResponseEntity.ok(productMapper.toDto(savedProduct));
    }

    @PutMapping("updateProductImage/{productId}")
    @Operation(summary = "Обновить информацию об изображении продукта")
    public ResponseEntity<ProductDto> updateProductImage(@PathVariable UUID productId, @RequestParam UUID imageId) {
        ProductModel updatedProduct = productService.updateProductImage(productId, imageId);
        return ResponseEntity.ok(productMapper.toDto(updatedProduct));
    }


    @PatchMapping("decrementAvailableStock/{id}/{count}")
    @Operation(summary = "Уменьшить количество доступного продукта по id на count")
    public ResponseEntity<ProductDto> decrementProduct(@PathVariable UUID id, @PathVariable int count) {
        return ResponseEntity.ok(productService.decrementAvailableStock(id, count));
    }

    @DeleteMapping("deleteProductById/{id}")
    @Operation(summary = "Удалить продукт по id")
    public void deleteProductById(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
