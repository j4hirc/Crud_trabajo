package com.example.jahir.Trabajo_Spring.dto.response;

import jakarta.persistence.JoinColumn;
import lombok.Data;

@Data
public class BodegueroResponse {

    private Long id;

    private String nombre;

    private String apellido;

    private Boolean estado;

}
