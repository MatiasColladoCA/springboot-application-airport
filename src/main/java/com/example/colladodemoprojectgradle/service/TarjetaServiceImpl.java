package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Tarjeta;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import com.example.colladodemoprojectgradle.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaServiceImpl extends BaseServiceImpl<Tarjeta, Long> implements TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    public TarjetaServiceImpl(BaseRepository<Tarjeta, Long> baseRepository, TarjetaRepository tarjetaRepository) {
        super(baseRepository);
        this.tarjetaRepository = tarjetaRepository;
    }
}
