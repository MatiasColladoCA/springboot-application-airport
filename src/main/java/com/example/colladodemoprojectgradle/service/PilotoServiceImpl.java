package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Piloto;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import com.example.colladodemoprojectgradle.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilotoServiceImpl extends BaseServiceImpl<Piloto, Long> implements PilotoService {
    @Autowired
    private PilotoRepository pilotoRepository;

    public PilotoServiceImpl(BaseRepository<Piloto, Long> baseRepository, PilotoRepository pilotoRepository) {
        super(baseRepository);
        this.pilotoRepository = pilotoRepository;
    }
}
