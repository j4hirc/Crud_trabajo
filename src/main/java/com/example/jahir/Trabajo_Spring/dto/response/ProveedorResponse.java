package com.example.jahir.Trabajo_Spring.dto.response;

import com.example.jahir.Trabajo_Spring.model.Bodeguero;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ProveedorResponse {
    private Long id;

    private String nombre;

    private String ubicacion;

    private Boolean estado;

    private Long bodegueroId;

    private String bodegueroName;
}
