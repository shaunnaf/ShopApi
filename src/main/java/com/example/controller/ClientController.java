package com.example.controller;

import com.example.dto.AddressDto;
import com.example.dto.ClientDto;
import com.example.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Клиенты", description = "Api для работы с клиентами")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/createClient")
    @Operation(summary = "Создать клиента")
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientDto));
    }

    @DeleteMapping("/deleteClient/{id}")
    @Operation(summary = "Удалить клиента по id")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getClientByNameAndSurname")
    @Operation(summary = "Получить клиента по имени и фамилии")
    public ResponseEntity<List<ClientDto>> getByNameAndSurname(String name, String surname) {
        return ResponseEntity.ok(clientService.getClientByNameAndSurname(name, surname));
    }

    @GetMapping("/getAllClient")
    @Operation(summary = "Получить всех клиентов")
    public ResponseEntity<List<ClientDto>> getAll(@RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset) {
        return ResponseEntity.ok(clientService.getAllClients(limit, offset));
    }

    @PatchMapping("/updateAddressClient")
    @Operation(summary = "Обновить адрес клиента")
    public ResponseEntity<ClientDto> updateAddress(@RequestBody AddressDto AddressDto) {
        return ResponseEntity.ok(clientService.updateAddress(AddressDto));
    }
}
