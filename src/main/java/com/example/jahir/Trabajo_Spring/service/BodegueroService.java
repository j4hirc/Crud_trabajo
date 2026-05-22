package com.example.jahir.Trabajo_Spring.service;

import com.example.jahir.Trabajo_Spring.dto.request.BodegueroRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegueroResponse;

import java.util.List;

public interface BodegueroService {
    List<BodegueroResponse> findAll();

    BodegueroResponse findById(Long id);

    BodegueroResponse createBodeguero(BodegueroRequest bodegueroRequest);

    BodegueroResponse updateBodeguero(Long id,BodegueroRequest bodegueroRequest);

    void deleteById(Long id);
}
