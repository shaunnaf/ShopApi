package com.example.controller;

import com.example.dto.AddressDto;
import com.example.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Адреса", description = "Api для работы с адресами")
public class AddressController {
    private final AddressService addressService;

    @PostMapping("addAddress")
    @Operation(summary = "Добавление нового адреса")
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto) {
        return ResponseEntity.ok(addressService.addAddress(addressDto));
    }

    @GetMapping("allAddress")
    @Operation(summary = "Вывод всех адресов в виде списка")
    public ResponseEntity<List<AddressDto>> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }
}
