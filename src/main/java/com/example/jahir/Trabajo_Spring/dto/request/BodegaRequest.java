package com.example.jahir.Trabajo_Spring.dto.request;

import lombok.Data;

@Data
public class BodegaRequest {

    private String ruc;

    private String nombreComercial;

    private String representanteLegal;

    private Integer credito;

    private String  direccion;

    private Integer telefono;

    private Boolean estado;




}
