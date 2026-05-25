package com.example.jahir.Trabajo_Spring.controller;

import com.example.jahir.Trabajo_Spring.dto.request.BodegaRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegaResponse;
import com.example.jahir.Trabajo_Spring.service.BodegaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bodegas")
@RequiredArgsConstructor
public class BodegaController {

    private final BodegaService bodegaService;

    @GetMapping
    public ResponseEntity<List<BodegaResponse>> getAllBodegas() {
        return ResponseEntity.ok(bodegaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegaResponse> getBodegaById(@PathVariable Long id) {
        return ResponseEntity.ok(bodegaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BodegaResponse> createBodega(@Valid @RequestBody BodegaRequest request) {
        BodegaResponse nuevaBodega = bodegaService.createBodega(request);
        return new ResponseEntity<>(nuevaBodega, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegaResponse> updateBodega(@PathVariable Long id, @Valid @RequestBody BodegaRequest request) {
        return ResponseEntity.ok(bodegaService.updateBodega(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBodega(@PathVariable Long id) {
        bodegaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}