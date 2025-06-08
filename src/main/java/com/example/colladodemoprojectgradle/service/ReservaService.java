package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Reserva;
import com.example.colladodemoprojectgradle.model.Reserva;

import java.util.List;

public interface ReservaService extends BaseService<Reserva, Long> {
    List<Reserva> findByUsuarioId(Long usuarioId) throws Exception;
    List<Reserva> findByVueloId(Long vueloId) throws Exception;
}