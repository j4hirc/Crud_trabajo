package com.example.jahir.Trabajo_Spring.service.mapper;

import com.example.jahir.Trabajo_Spring.dto.request.ProveedorRequest;
import com.example.jahir.Trabajo_Spring.dto.response.ProveedorResponse;
import com.example.jahir.Trabajo_Spring.model.Bodeguero;
import com.example.jahir.Trabajo_Spring.model.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapper {
    public Proveedor toEntity(ProveedorRequest proveedorRequest, Bodeguero bodeguero){
        Proveedor entity = new Proveedor();
        entity.setNombre(proveedorRequest.getNombre());
        entity.setUbicacion(proveedorRequest.getUbicacion());
        entity.setEstado(proveedorRequest.getEstado());
        entity.setBodeguero(bodeguero);
        return entity;
    }

    public ProveedorResponse toResponse(Proveedor proveedor){
        ProveedorResponse dto = new ProveedorResponse();
        dto.setId(proveedor.getId());
        dto.setNombre(proveedor.getNombre());
        dto.setUbicacion(proveedor.getUbicacion());
        dto.setEstado(proveedor.getEstado());
        dto.setBodegueroId(proveedor.getBodeguero().getId());
        dto.setBodegueroName(proveedor.getBodeguero().getNombre());
        return dto;
    }

}
