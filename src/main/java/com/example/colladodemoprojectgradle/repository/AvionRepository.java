package com.example.colladodemoprojectgradle.repository;

//package com.example.vuelos.repository;

//import com.example.vuelos.model.Avion;
import com.example.colladodemoprojectgradle.model.Avion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvionRepository extends BaseRepository<Avion, Long> {

    @Query("SELECT a FROM Avion a WHERE a.tipoAvion = :tipo")
    List<Avion> findByTipoAvion(@Param("tipo") String tipo);
}