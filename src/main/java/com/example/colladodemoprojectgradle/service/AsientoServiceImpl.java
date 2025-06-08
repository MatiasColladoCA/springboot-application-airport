package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Asiento;
import com.example.colladodemoprojectgradle.model.ClaseServicio;
import com.example.colladodemoprojectgradle.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoServiceImpl extends BaseServiceImpl<Asiento, Long> implements AsientoService {
    private final AsientoRepository repository;

    @Autowired
    public AsientoServiceImpl(AsientoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<Asiento> findByAvionId(Long avionId) throws Exception {
        return repository.findByAvionId(avionId);
    }

    @Override
    public List<Asiento> findByClase(ClaseServicio clase) throws Exception {
        return repository.findByClaseAsiento(clase);
    }
}