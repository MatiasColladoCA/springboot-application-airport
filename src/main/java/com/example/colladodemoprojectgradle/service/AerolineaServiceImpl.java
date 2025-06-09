package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Aerolinea;
import com.example.colladodemoprojectgradle.repository.AerolineaRepository;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AerolineaServiceImpl extends BaseServiceImpl<Aerolinea, Long> implements AerolineaService {
    @Autowired
    private AerolineaRepository aerolineaRepository;

    public AerolineaServiceImpl(BaseRepository<Aerolinea, Long> baseRepository, AerolineaRepository aerolineaRepository) {
        super(baseRepository);
        this.aerolineaRepository = aerolineaRepository;
    }
}
