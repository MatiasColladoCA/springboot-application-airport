package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Pago;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import com.example.colladodemoprojectgradle.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl extends BaseServiceImpl<Pago, Long> implements PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    public PagoServiceImpl(BaseRepository<Pago, Long> baseRepository, PagoRepository pagoRepository) {
        super(baseRepository);
        this.pagoRepository = pagoRepository;
    }
}
