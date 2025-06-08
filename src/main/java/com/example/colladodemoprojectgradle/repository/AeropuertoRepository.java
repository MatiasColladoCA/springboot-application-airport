package com.example.colladodemoprojectgradle.repository;

import com.example.colladodemoprojectgradle.model.Aeropuerto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AeropuertoRepository extends BaseRepository<Aeropuerto, Long> {

    List<Aeropuerto> findByNombreAeropuertoContaining(String nombre);

    @Query("SELECT a FROM Aeropuerto a WHERE a.ciudad.nombreCiudad = :ciudad")
    List<Aeropuerto> findByCiudad(@Param("ciudad") String ciudad);


}