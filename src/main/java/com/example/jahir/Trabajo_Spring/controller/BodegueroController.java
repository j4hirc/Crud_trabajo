package com.example.jahir.Trabajo_Spring.controller;


import com.example.jahir.Trabajo_Spring.dto.request.BodegueroRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegueroResponse;
import com.example.jahir.Trabajo_Spring.service.BodegueroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bodeguero")
@RequiredArgsConstructor
public class BodegueroController {


    private final BodegueroService bodegueroService;

    @GetMapping
    public ResponseEntity<List<BodegueroResponse>> getAll(){
        List<BodegueroResponse> bodegueroResponses = bodegueroService.findAll();
        return ResponseEntity.ok(bodegueroResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegueroResponse> findById(@PathVariable Long id){
        BodegueroResponse bodegueroResponse = bodegueroService.findById(id);
        return ResponseEntity.ok(bodegueroResponse);
    }

    @PostMapping
    public ResponseEntity<BodegueroResponse> createBodeguero(@Valid @RequestBody BodegueroRequest bodegueroRequest){
        BodegueroResponse bodegueroResponse = bodegueroService.createBodeguero(bodegueroRequest);
        return new ResponseEntity<>(bodegueroResponse, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<BodegueroResponse> updateBodeguero(@PathVariable Long id,@Valid @RequestBody BodegueroRequest bodegueroRequest){
        BodegueroResponse bodegueroResponse = bodegueroService.updateBodeguero(id,bodegueroRequest);
        return ResponseEntity.ok(bodegueroResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        bodegueroService.deleteById(id);
        return ResponseEntity.ok("Eliminado con exito");
    }


}
