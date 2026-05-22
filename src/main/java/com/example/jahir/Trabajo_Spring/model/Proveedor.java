package com.example.jahir.Trabajo_Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bodegero_id", nullable = false)
    private Bodeguero bodeguero;

    @JoinColumn(nullable = false)
    private String ubicacion;

    @JoinColumn(nullable = false)
    private Boolean estado;

}
