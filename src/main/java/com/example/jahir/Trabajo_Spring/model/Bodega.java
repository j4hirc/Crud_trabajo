package com.example.jahir.Trabajo_Spring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "bodega")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    private String ruc;

    @JoinColumn(nullable = false)
    private String nombreComercial;

    @JoinColumn(nullable = false)
    private String representanteLegal;

    @JoinColumn(nullable = false)
    private Integer credito;

    @JoinColumn(nullable = false)
    private String  direccion;

    @JoinColumn(nullable = false)
    private Integer telefono;

    @JoinColumn(nullable = false)
    private Boolean estado;



}
