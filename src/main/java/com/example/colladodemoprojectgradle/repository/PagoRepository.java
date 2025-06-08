package com.example.colladodemoprojectgradle.repository;

//package com.example.vuelos.repository;
//
//import com.example.vuelos.model.Pago;
import com.example.colladodemoprojectgradle.model.Pago;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagoRepository extends BaseRepository<Pago, Long> {

    @Query("SELECT p FROM Pago p WHERE p.reserva.id = :reservaId")
    Optional<Pago> findByReservaId(@Param("reservaId") Long reservaId);

    @Query("SELECT p FROM Pago p WHERE p.numeroPago = :numero")
    Optional<Pago> findByNumeroPago(@Param("numero") String numeroPago);
}