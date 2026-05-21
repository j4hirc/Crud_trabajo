package com.example.jahir.Trabajo_Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "bodeguero")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bodeguero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    private String nombre;

    @JoinColumn(nullable = false)
    private String apellido;

    @JoinColumn(nullable = false)
    private Boolean estado;


}
