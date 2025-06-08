package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Piloto;
import com.example.colladodemoprojectgradle.model.Piloto;

import java.util.Optional;

public interface PilotoService extends BaseService<Piloto, Long> {
    Optional<Piloto> findByNumeroPiloto(String numeroPiloto) throws Exception;
}