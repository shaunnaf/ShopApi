package com.example.controller;

import com.example.dto.AddressDto;
import com.example.dto.SupplierDto;
import com.example.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name = "Поставщики продуктов")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("getAllSupplier")
    @Operation(summary = "Показать всех поставщиков")
    public ResponseEntity<List<SupplierDto>> getAllSupplier() {
        return ResponseEntity.ok(supplierService.getAllSupplier());
    }

    @GetMapping("getByIdSupplier/{id}")
    @Operation(summary = "Показать поставщика по id")
    public ResponseEntity<SupplierDto> getByIdSupplier(@PathVariable UUID id) {
        return ResponseEntity.ok(supplierService.getByIdSupplier(id));
    }

    @DeleteMapping("deleteSupplier/{id}")
    @Operation(summary = "Удалить поставщика")
    public void deleteSupplier(@PathVariable UUID id) {
        supplierService.deleteByIdSupplier(id);
    }

    @PostMapping("addSupplier")
    @Operation(summary = "Добавить поставщика")
    public ResponseEntity<SupplierDto> addSupplier(@RequestBody SupplierDto supplierDto) {
        return ResponseEntity.ok(supplierService.addSupplier(supplierDto));
    }

    @PatchMapping("updateAddressSupplier")
    @Operation(summary = "Обновить адрес поставщика")
    public ResponseEntity<SupplierDto> updateAddress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(supplierService.updateAddressSuppllier(addressDto));
    }
}
