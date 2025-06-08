package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Aerolinea;
import com.example.colladodemoprojectgradle.repository.AerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AerolineaServiceImpl extends BaseServiceImpl<Aerolinea, Long> implements AerolineaService {
    private final AerolineaRepository repository;

    @Autowired
    public AerolineaServiceImpl(AerolineaRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<Aerolinea> findByNombre(String nombre) throws Exception {
        return repository.findByNombreAerolinea(nombre);
    }
}