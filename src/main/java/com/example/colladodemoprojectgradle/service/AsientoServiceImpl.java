package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Asiento;
import com.example.colladodemoprojectgradle.repository.AsientoRepository;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsientoServiceImpl extends BaseServiceImpl<Asiento, Long> implements AsientoService {
    @Autowired
    private AsientoRepository asientoRepository;

    public AsientoServiceImpl(BaseRepository<Asiento, Long> baseRepository, AsientoRepository asientoRepository) {
        super(baseRepository);
        this.asientoRepository = asientoRepository;
    }
}
