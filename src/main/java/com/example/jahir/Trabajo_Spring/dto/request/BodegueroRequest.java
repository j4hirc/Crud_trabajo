package com.example.jahir.Trabajo_Spring.dto.request;

import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BodegueroRequest {

    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El campo apellido no puede estar vacio")
    private String apellido;

    private Boolean estado;

}
