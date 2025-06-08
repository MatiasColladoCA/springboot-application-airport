package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Vuelo;
import com.example.colladodemoprojectgradle.model.Vuelo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;

public interface VueloService extends BaseService<Vuelo, Long> {
    List<Vuelo> findByRangoFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception;
    Page<Vuelo> findByAeropuerto(Long aeropuertoId, Pageable pageable) throws Exception;
}