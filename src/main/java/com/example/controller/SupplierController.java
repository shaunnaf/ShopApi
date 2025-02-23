package com.example.controller;

import com.example.dto.AddressDto;
import com.example.dto.SupplierDto;
import com.example.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("getAllSupplier")
    public ResponseEntity<List<SupplierDto>> getAllSupplier() {
        return ResponseEntity.ok(supplierService.getAllSupplier());
    }

    @GetMapping("getByIdSupplier/{id}")
    public ResponseEntity<SupplierDto> getByIdSupplier(@PathVariable UUID id) {
        return ResponseEntity.ok(supplierService.getByIdSupplier(id));
    }

    @DeleteMapping("deleteSupplier/{id}")
    public void deleteSupplier(@PathVariable UUID id) {
        supplierService.deleteByIdSupplier(id);
    }

    @PostMapping("addSupplier")
    public ResponseEntity<SupplierDto> addSupplier(@RequestBody SupplierDto supplierDto) {
        return ResponseEntity.ok(supplierService.addSupplier(supplierDto));
    }

    @PatchMapping("updateAddressSupplier")
    public ResponseEntity<SupplierDto> updateAddress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(supplierService.updateAddressSuppllier(addressDto));
    }
}
