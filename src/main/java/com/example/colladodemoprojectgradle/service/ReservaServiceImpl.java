package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Reserva;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import com.example.colladodemoprojectgradle.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<Reserva, Long> implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public ReservaServiceImpl(BaseRepository<Reserva, Long> baseRepository, ReservaRepository reservaRepository) {
        super(baseRepository);
        this.reservaRepository = reservaRepository;
    }
}
