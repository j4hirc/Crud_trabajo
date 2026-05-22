package com.example.jahir.Trabajo_Spring.repository;

import com.example.jahir.Trabajo_Spring.model.Proveedor;
import lombok.NonNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepositoryProveedor extends JpaRepository<Proveedor, Long> {

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"bodeguero"})
    Optional<Proveedor> findById(@NonNull Long id);

}
