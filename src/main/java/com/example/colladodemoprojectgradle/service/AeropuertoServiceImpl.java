package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Aeropuerto;
import com.example.colladodemoprojectgradle.repository.AeropuertoRepository;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AeropuertoServiceImpl extends BaseServiceImpl<Aeropuerto, Long> implements AeropuertoService {
    @Autowired
    private AeropuertoRepository aeropuertoRepository;

    public AeropuertoServiceImpl(BaseRepository<Aeropuerto, Long> baseRepository, AeropuertoRepository aeropuertoRepository) {
        super(baseRepository);
        this.aeropuertoRepository = aeropuertoRepository;
    }
}
