package com.example.jahir.Trabajo_Spring.controller;

import com.example.jahir.Trabajo_Spring.dto.request.BodegaRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegaResponse;
import com.example.jahir.Trabajo_Spring.service.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bodega")
public class BodegaController {

    private BodegaService bodegaService;

    @GetMapping("/all")
    public ResponseEntity<List<BodegaResponse>> findAll(){
        List<BodegaResponse> bodegaResponses = bodegaService.findAll();
        return ResponseEntity.ok(bodegaResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegaResponse> findById(@PathVariable Long id){
        BodegaResponse bodegaResponse = bodegaService.findById(id);
        return ResponseEntity.ok(bodegaResponse);
    }

    @PostMapping("/create-bodega")
    public ResponseEntity<BodegaResponse> createBodega(@RequestBody BodegaRequest bodegaRequest){
        BodegaResponse bodegaResponse = bodegaService.createBodega(bodegaRequest);
        return new ResponseEntity<>(bodegaResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update-bodega/{id}")
    public ResponseEntity<BodegaResponse> updateBodega(@PathVariable Long id, @RequestBody BodegaRequest bodegaRequest){
        BodegaResponse bodegaResponse = bodegaService.updateBodega(id,bodegaRequest);
        return ResponseEntity.ok(bodegaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        bodegaService.deleteById(id);
        return ResponseEntity.ok("Eliminado con exito");
    }

}
