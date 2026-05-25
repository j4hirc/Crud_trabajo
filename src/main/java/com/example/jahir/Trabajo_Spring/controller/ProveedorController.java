package com.example.jahir.Trabajo_Spring.controller;

import com.example.jahir.Trabajo_Spring.dto.request.ProveedorRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegueroResponse;
import com.example.jahir.Trabajo_Spring.dto.response.ProveedorResponse;
import com.example.jahir.Trabajo_Spring.service.ProveedorService;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedor")
@RequiredArgsConstructor
public class ProveedorController {
    private final ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorResponse>> getAll(){
        List<ProveedorResponse> proveedorResponses = proveedorService.findAll();
        return ResponseEntity.ok(proveedorResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponse> findById(@PathVariable Long id){
        ProveedorResponse proveedorResponse = proveedorService.findById(id);
        return ResponseEntity.ok(proveedorResponse);
    }

    @PostMapping
    public ResponseEntity<ProveedorResponse> createProveedor(@Valid @RequestBody ProveedorRequest proveedorRequest){
        ProveedorResponse proveedorResponse = proveedorService.createProveedor(proveedorRequest);
        return new ResponseEntity<>(proveedorResponse, HttpStatus.CREATED);
    }

    @PutMapping("/id")
    public  ResponseEntity<ProveedorResponse> updateProveedor(@PathVariable Long id, @RequestBody ProveedorRequest proveedorRequest){
        ProveedorResponse proveedorResponse = proveedorService.updateProveedor(id,proveedorRequest);
        return ResponseEntity.ok(proveedorResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        proveedorService.deleteById(id);
        return ResponseEntity.ok("Eliminado Correctamente");
    }

}
