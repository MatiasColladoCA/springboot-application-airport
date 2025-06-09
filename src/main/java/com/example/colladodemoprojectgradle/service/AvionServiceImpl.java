package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Avion;
import com.example.colladodemoprojectgradle.repository.AvionRepository;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvionServiceImpl extends BaseServiceImpl<Avion, Long> implements AvionService {
    @Autowired
    private AvionRepository avionRepository;

    public AvionServiceImpl(BaseRepository<Avion, Long> baseRepository, AvionRepository avionRepository) {
        super(baseRepository);
        this.avionRepository = avionRepository;
    }
}
