package com.example.colladodemoprojectgradle.repository;

//package com.example.vuelos.repository;

//import com.example.vuelos.model.Consulta;
import com.example.colladodemoprojectgradle.model.Consulta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends BaseRepository<Consulta, Long> {

    List<Consulta> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);

    @Query("SELECT c FROM Consulta c WHERE c.usuario.id = :usuarioId")
    List<Consulta> findByUsuarioId(@Param("usuarioId") Long usuarioId);
}