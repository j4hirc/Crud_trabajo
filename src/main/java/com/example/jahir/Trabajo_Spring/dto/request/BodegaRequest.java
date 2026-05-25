package com.example.jahir.Trabajo_Spring.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BodegaRequest {

    @NotEmpty(message = "El campo ruc no puede estar vacio")
    private String ruc;

    @NotEmpty(message = "El nombre comercial ruc no puede estar vacio")
    private String nombreComercial;

    @NotEmpty(message = "El campo representante legal no puede estar vacio")
    private String representanteLegal;

    @NotNull(message = "El campo credito no puede ser nulo")
    @Min(value = 1, message = "Debe ser mayor a 1")
    private Integer credito;

    @NotEmpty(message = "El campo dirección no puede estar vacio")
    private String  direccion;

    @NotNull(message = "El campo telefono no puede ser nulo")
    private String telefono;

    private Boolean estado;




}
