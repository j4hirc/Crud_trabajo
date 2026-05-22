package com.example.jahir.Trabajo_Spring.service;

import com.example.jahir.Trabajo_Spring.dto.request.BodegaRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegaResponse;

import java.util.List;

public interface BodegaService {

    List<BodegaResponse> findAll();

    BodegaResponse findById(Long id);

    BodegaResponse createBodega(BodegaRequest bodegaRequest);

    BodegaResponse updateBodega(Long id, BodegaRequest bodegaRequest);

    void deleteById(Long id);


}
