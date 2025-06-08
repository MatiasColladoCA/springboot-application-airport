package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Aerolinea;
import com.example.colladodemoprojectgradle.model.Aerolinea;

import java.util.Optional;

public interface AerolineaService extends BaseService<Aerolinea, Long> {
    Optional<Aerolinea> findByNombre(String nombre) throws Exception;
}