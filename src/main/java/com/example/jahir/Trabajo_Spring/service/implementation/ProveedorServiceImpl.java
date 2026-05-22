package com.example.jahir.Trabajo_Spring.service.implementation;

import com.example.jahir.Trabajo_Spring.dto.request.ProveedorRequest;
import com.example.jahir.Trabajo_Spring.dto.response.ProveedorResponse;
import com.example.jahir.Trabajo_Spring.exception.ResourceNotFoundException;
import com.example.jahir.Trabajo_Spring.model.Bodeguero;
import com.example.jahir.Trabajo_Spring.model.Proveedor;
import com.example.jahir.Trabajo_Spring.repository.RepositoryBodeguero;
import com.example.jahir.Trabajo_Spring.repository.RepositoryProveedor;
import com.example.jahir.Trabajo_Spring.service.BodegueroService;
import com.example.jahir.Trabajo_Spring.service.ProveedorService;
import com.example.jahir.Trabajo_Spring.service.mapper.ProveedorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {
    private final RepositoryProveedor repositoryProveedor;
    private final RepositoryBodeguero repositoryBodeguero;
    private final ProveedorMapper proveedorMapper;

    @Override
    public List<ProveedorResponse> findAll() {
        List<Proveedor> proveedores = repositoryProveedor.findAll();
        return proveedores.stream()
                .map(proveedorMapper::toResponse)
                .toList();
    }


    @Override
    public ProveedorResponse findById(Long id) {
        Proveedor proveedor = repositoryProveedor.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("El proveedor no existe"));
        return proveedorMapper.toResponse(proveedor);
    }

    @Override
    public ProveedorResponse createProveedor(ProveedorRequest proveedorRequest) {
        Bodeguero bodeguero = repositoryBodeguero.findById(proveedorRequest.getBodegueroId())
                .orElseThrow(()-> new ResourceNotFoundException("El Bodeguero no existe"));

        Proveedor proveedorSaved = repositoryProveedor.save(proveedorMapper.toEntity(proveedorRequest,bodeguero));

        return proveedorMapper.toResponse(proveedorSaved);
    }

    @Override
    public ProveedorResponse updateProveedor(Long id, ProveedorRequest proveedorRequest) {
        Proveedor proveedor = repositoryProveedor.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El proveedor no existe"));
        Bodeguero bodeguero = repositoryBodeguero.findById(proveedorRequest.getBodegueroId())
                .orElseThrow(()-> new ResourceNotFoundException("El Bodeguero no existe"));

        proveedor.setNombre(proveedorRequest.getNombre());
        proveedor.setUbicacion(proveedorRequest.getUbicacion());
        proveedor.setBodeguero(bodeguero);
        proveedor.setEstado(proveedorRequest.getEstado());

        Proveedor proveedorSaved = repositoryProveedor.save(proveedor);
        return proveedorMapper.toResponse(proveedorSaved);
    }

    @Override
    public void deleteById(Long id) {
        repositoryProveedor.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El proveedor no existe"));

        repositoryProveedor.deleteById(id);

    }
}
