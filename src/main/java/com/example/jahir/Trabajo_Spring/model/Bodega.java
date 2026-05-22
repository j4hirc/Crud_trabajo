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

    @Column(nullable = false)
    private String ruc;

    @Column(nullable = false)
    private String nombreComercial;

    @Column(nullable = false)
    private String representanteLegal;

    @Column(nullable = false)
    private Integer credito;

    @Column(nullable = false)
    private String  direccion;

    @Column(nullable = false)
    private Integer telefono;

    @Column(nullable = false)
    private Boolean estado;



}
