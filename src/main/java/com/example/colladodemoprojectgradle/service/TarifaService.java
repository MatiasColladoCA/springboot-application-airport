package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Tarifa;
//import com.example.vuelos.model.enums.ClaseServicio;
import com.example.colladodemoprojectgradle.model.ClaseServicio;
import com.example.colladodemoprojectgradle.model.Tarifa;

import java.util.List;
import java.util.Optional;

public interface TarifaService extends BaseService<Tarifa, Long> {
    List<Tarifa> findByClaseTarifa(ClaseServicio clase) throws Exception;
    List<Tarifa> findByVueloId(Long vueloId) throws Exception;
//    Optional<Tarifa> findByVueloAndClase(Long vueloId, ClaseServicio clase) throws Exception;
}