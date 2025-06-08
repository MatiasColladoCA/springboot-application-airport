package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Piloto;
import com.example.colladodemoprojectgradle.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PilotoServiceImpl extends BaseServiceImpl<Piloto, Long> implements PilotoService {
    private final PilotoRepository repository;

    @Autowired
    public PilotoServiceImpl(PilotoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Optional<Piloto> findByNumeroPiloto(String numeroPiloto) throws Exception {
        return repository.findByNumeroPiloto(numeroPiloto);
    }
}