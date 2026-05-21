package com.example.jahir.Trabajo_Spring.service.implementation;

import com.example.jahir.Trabajo_Spring.dto.request.BodegaRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegaResponse;
import com.example.jahir.Trabajo_Spring.exception.ResourceNotFoundException;
import com.example.jahir.Trabajo_Spring.model.Bodega;
import com.example.jahir.Trabajo_Spring.repository.RepositoryBodega;
import com.example.jahir.Trabajo_Spring.service.BodegaService;
import com.example.jahir.Trabajo_Spring.service.mapper.BodegaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegaServiceImpl implements BodegaService {

    private final RepositoryBodega repositoryBodega;
    private final BodegaMapper bodegaMapper;

    @Override
    public List<BodegaResponse> findAll() {
        List<Bodega> bodegas = repositoryBodega.findAll();

        return bodegas.stream()
                .map(bodegaMapper::toResponse)
                .toList();
    }

    @Override
    public BodegaResponse findById(Long id) {
        Bodega bodega = repositoryBodega.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe esa bodega"));
        return bodegaMapper.toResponse(bodega);
    }

    @Override
    public BodegaResponse createBodega(BodegaRequest bodegaRequest) {
        Bodega bodega = repositoryBodega.save(bodegaMapper.toRequestDto(bodegaRequest));
        return bodegaMapper.toResponse(bodega);
    }

    @Override
    public BodegaResponse updateResponse(Long id, BodegaRequest bodegaRequest) {
        Bodega bodega = repositoryBodega.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe esa bodega"));
        bodega.setRuc(bodegaRequest.getRuc());
        bodega.setNombreComercial(bodegaRequest.getNombreComercial());
        bodega.setRepresentanteLegal(bodegaRequest.getRepresentanteLegal());
        bodega.setCredito(bodegaRequest.getCredito());
        bodega.setDireccion(bodegaRequest.getDireccion());
        bodega.setTelefono(bodegaRequest.getTelefono());
        bodega.setEstado(bodegaRequest.getEstado());

        return bodegaMapper.toResponse(bodega);
    }

    @Override
    public void deleteById(Long id) {
        Bodega bodega = repositoryBodega.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe esa bodega"));

        repositoryBodega.deleteById(id);
    }

}
