package com.example.jahir.Trabajo_Spring.service;

import com.example.jahir.Trabajo_Spring.dto.request.ProveedorRequest;
import com.example.jahir.Trabajo_Spring.dto.response.ProveedorResponse;

import java.util.List;

public interface ProveedorService {
    List<ProveedorResponse> findAll();

    ProveedorResponse findById(Long id);

    ProveedorResponse createProveedor(ProveedorRequest proveedorRequest);

    ProveedorResponse updateProveedor(Long id, ProveedorRequest proveedorRequest);

    void deleteById(Long id);
}
