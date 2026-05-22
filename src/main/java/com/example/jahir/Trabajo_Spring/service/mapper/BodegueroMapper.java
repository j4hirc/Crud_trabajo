package com.example.jahir.Trabajo_Spring.service.mapper;

import com.example.jahir.Trabajo_Spring.dto.request.BodegueroRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegueroResponse;
import com.example.jahir.Trabajo_Spring.model.Bodeguero;
import org.springframework.stereotype.Component;

@Component
public class BodegueroMapper {

    public Bodeguero toEntity(BodegueroRequest bodegueroRequest){
        Bodeguero entity = new Bodeguero();
        entity.setNombre(bodegueroRequest.getNombre());
        entity.setApellido(bodegueroRequest.getApellido());
        entity.setEstado(bodegueroRequest.getEstado());
        return entity;
    }


    public BodegueroResponse toResponseDto(Bodeguero bodeguero){
        BodegueroResponse dto = new BodegueroResponse();
        dto.setId(bodeguero.getId());
        dto.setNombre(bodeguero.getNombre());
        dto.setApellido(bodeguero.getApellido());
        dto.setEstado(bodeguero.getEstado());
        return dto;
    }

}
