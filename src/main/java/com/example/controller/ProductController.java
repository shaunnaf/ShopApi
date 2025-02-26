package com.example.controller;

import com.example.dto.ProductDto;
import com.example.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Продукты", description = "Api для работы с продуктами")
public class ProductController {
    private final ProductService productService;

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
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productDto));
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
