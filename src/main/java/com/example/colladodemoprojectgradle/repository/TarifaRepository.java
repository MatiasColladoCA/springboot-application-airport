package com.example.colladodemoprojectgradle.repository;

//import com.example.vuelos.model.Tarifa;
//import com.example.vuelos.model.enums.ClaseServicio;
import com.example.colladodemoprojectgradle.model.ClaseServicio;
import com.example.colladodemoprojectgradle.model.Tarifa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarifaRepository extends BaseRepository<Tarifa, Long> {

    List<Tarifa> findByClaseTarifa(ClaseServicio clase);

    List<Tarifa> findByVueloId(Long vueloId);
}