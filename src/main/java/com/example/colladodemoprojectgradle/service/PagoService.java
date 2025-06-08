package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Pago;
import com.example.colladodemoprojectgradle.model.Pago;

import java.util.Optional;

public interface PagoService extends BaseService<Pago, Long> {
    Optional<Pago> findByReservaId(Long reservaId) throws Exception;
}