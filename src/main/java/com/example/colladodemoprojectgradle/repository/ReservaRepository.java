package com.example.colladodemoprojectgradle.repository;


//import com.example.vuelos.model.Reserva;
import com.example.colladodemoprojectgradle.model.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends BaseRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r WHERE r.usuario.id = :usuarioId")
    List<Reserva> findByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT r FROM Reserva r WHERE r.vuelo.id = :vueloId")
    List<Reserva> findByVueloId(@Param("vueloId") Long vueloId);
}