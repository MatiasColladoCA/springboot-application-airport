package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Tarifa;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import com.example.colladodemoprojectgradle.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarifaServiceImpl extends BaseServiceImpl<Tarifa, Long> implements TarifaService {
    @Autowired
    private TarifaRepository tarifaRepository;

    public TarifaServiceImpl(BaseRepository<Tarifa, Long> baseRepository, TarifaRepository tarifaRepository) {
        super(baseRepository);
        this.tarifaRepository = tarifaRepository;
    }
}
