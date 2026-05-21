package com.example.jahir.Trabajo_Spring.service.mapper;

import com.example.jahir.Trabajo_Spring.dto.request.BodegaRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegaResponse;
import com.example.jahir.Trabajo_Spring.model.Bodega;
import org.springframework.stereotype.Component;

@Component
public class BodegaMapper {

    public BodegaResponse toResponse(Bodega bodega){
        BodegaResponse dto = new BodegaResponse();
        dto.setId(bodega.getId());
        dto.setRuc(bodega.getRuc());
        dto.setNombreComercial(bodega.getNombreComercial());
        dto.setRepresentanteLegal(bodega.getRepresentanteLegal());
        dto.setCredito(bodega.getCredito());
        dto.setDireccion(bodega.getDireccion());
        dto.setTelefono(bodega.getTelefono());
        dto.setEstado(bodega.getEstado());
        return dto;
    }


    public Bodega toRequestDto(BodegaRequest bodegaRequest){
        Bodega entity = new Bodega();
        entity.setRuc(bodegaRequest.getRuc());
        entity.setNombreComercial(bodegaRequest.getNombreComercial());
        entity.setRepresentanteLegal(bodegaRequest.getRepresentanteLegal());
        entity.setCredito(bodegaRequest.getCredito());
        entity.setDireccion(bodegaRequest.getDireccion());
        entity.setTelefono(bodegaRequest.getTelefono());
        entity.setEstado(bodegaRequest.getEstado());
        return entity;
    }




}
