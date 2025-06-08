package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Asiento;
//import com.example.vuelos.model.enums.ClaseServicio;
import com.example.colladodemoprojectgradle.model.Asiento;
import com.example.colladodemoprojectgradle.model.ClaseServicio;

import java.util.List;

public interface AsientoService extends BaseService<Asiento, Long> {
    List<Asiento> findByAvionId(Long avionId) throws Exception;
    List<Asiento> findByClase(ClaseServicio clase) throws Exception;
}