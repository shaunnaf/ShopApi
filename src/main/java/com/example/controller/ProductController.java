package com.example.controller;

import com.example.dto.ProductDto;
import com.example.mapper.ProductMapper;
import com.example.model.ProductModel;
import com.example.model.SupplierModel;
import com.example.repository.SupplierRepository;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;
    private final SupplierRepository supplierRepository;
    private final ProductMapper productMapper;

    @GetMapping("getProductById/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("getAllProduct")
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping("addProduct")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        ProductModel productModel = productMapper.toEntity(productDto);

        SupplierModel supplier = supplierRepository.findById(productDto.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        productModel.setSupplier(supplier);

        ProductModel savedProduct = productService.addProduct(productModel);
        return ResponseEntity.ok(productMapper.toDto(savedProduct));
    }

    @PutMapping("updateProductImage/{productId}")
    public ResponseEntity<ProductDto> updateProductImage(@PathVariable UUID productId, @RequestParam UUID imageId) {
        ProductModel updatedProduct = productService.updateProductImage(productId, imageId);
        return ResponseEntity.ok(productMapper.toDto(updatedProduct));
    }


    @PatchMapping("decrementAvailableStock/{id}/{count}")
    public ResponseEntity<ProductDto> decrementProduct(@PathVariable UUID id, @PathVariable int count) {
        return ResponseEntity.ok(productService.decrementAvailableStock(id, count));
    }

    @DeleteMapping("deleteProductById/{id}")
    public void deleteProductById(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
