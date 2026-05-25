package com.example.jahir.Trabajo_Spring.dto.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BodegaResponse {
    private Long id;

    private String ruc;

    private String nombreComercial;

    private String representanteLegal;

    private Integer credito;

    private String  direccion;

    private String telefono;

    private Boolean estado;
}
