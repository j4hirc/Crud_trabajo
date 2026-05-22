package com.example.jahir.Trabajo_Spring.dto.request;

import com.example.jahir.Trabajo_Spring.model.Bodeguero;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProveedorRequest {

    @NotBlank(message = "El campo nombre no puede estar vacio")
    private String nombre;

    @NotNull(message = "El campo bodegueroId no puede ser nulo")
    private Long bodegueroId;

    @NotBlank(message = "El campo ubicación no puede estar vacio")
    private String ubicacion;


    private Boolean estado;
}
