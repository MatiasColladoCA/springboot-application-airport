package com.example.colladodemoprojectgradle.repository;

//package com.example.vuelos.repository;

//import com.example.vuelos.model.Aerolinea;
import com.example.colladodemoprojectgradle.model.Aerolinea;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AerolineaRepository extends BaseRepository<Aerolinea, Long> {

    Optional<Aerolinea> findByNombreAerolinea(String nombre);
}