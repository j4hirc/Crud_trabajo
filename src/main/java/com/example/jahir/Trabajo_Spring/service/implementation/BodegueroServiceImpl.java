package com.example.jahir.Trabajo_Spring.service.implementation;

import com.example.jahir.Trabajo_Spring.dto.request.BodegueroRequest;
import com.example.jahir.Trabajo_Spring.dto.response.BodegueroResponse;
import com.example.jahir.Trabajo_Spring.exception.ResourceNotFoundException;
import com.example.jahir.Trabajo_Spring.model.Bodeguero;
import com.example.jahir.Trabajo_Spring.repository.RepositoryBodeguero;
import com.example.jahir.Trabajo_Spring.service.BodegueroService;
import com.example.jahir.Trabajo_Spring.service.mapper.BodegueroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BodegueroServiceImpl implements BodegueroService {

    private final RepositoryBodeguero repositoryBodeguero;
    private final BodegueroMapper bodegueroMapper;

    @Override
    public List<BodegueroResponse> findAll() {
        List<Bodeguero> bodegueros = repositoryBodeguero.findAll();
        return bodegueros.stream()
                .map(bodegueroMapper::toResponseDto)
                .toList();
    }

    @Override
    public BodegueroResponse findById(Long id) {
        Bodeguero bodeguero =repositoryBodeguero.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El Bodeguero no existe"));

        return bodegueroMapper.toResponseDto(bodeguero);
    }

    @Override
    public BodegueroResponse createBodeguero(BodegueroRequest bodegueroRequest) {
        Bodeguero bodeguero = repositoryBodeguero.save(bodegueroMapper.toEntity(bodegueroRequest));
        return bodegueroMapper.toResponseDto(bodeguero);
    }

    @Override
    public BodegueroResponse updateBodeguero(Long id, BodegueroRequest bodegueroRequest) {
        Bodeguero bodeguero = repositoryBodeguero.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El bodeguero no existe"));
        bodeguero.setNombre(bodegueroRequest.getNombre());
        bodeguero.setApellido(bodegueroRequest.getApellido());
        bodeguero.setEstado(bodegueroRequest.getEstado());

        Bodeguero bodegueroSaved = repositoryBodeguero.save(bodeguero);
        return bodegueroMapper.toResponseDto(bodegueroSaved);
    }

    @Override
    public void deleteById(Long id) {
        repositoryBodeguero.findById(id).orElseThrow(()-> new ResourceNotFoundException("El bodeguero no existe"));
        repositoryBodeguero.deleteById(id);

    }

    
}
