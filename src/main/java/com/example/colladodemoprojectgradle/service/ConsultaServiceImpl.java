package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Consulta;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import com.example.colladodemoprojectgradle.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl extends BaseServiceImpl<Consulta, Long> implements ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(BaseRepository<Consulta, Long> baseRepository, ConsultaRepository consultaRepository) {
        super(baseRepository);
        this.consultaRepository = consultaRepository;
    }
}
