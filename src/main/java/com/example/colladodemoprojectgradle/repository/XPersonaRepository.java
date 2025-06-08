package com.example.colladodemoprojectgradle.repository;

import com.example.colladodemoprojectgradle.model.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//Se comunica con la BBDD
@Repository
public interface XPersonaRepository extends BaseRepository<Persona, Long> {

    // Anotación metodo de query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    // Paginacion
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);


    // Anotación JPQL parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    List<Persona> search(@Param("filtro") String filtro);

    // Paginacion
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR perosna.apellido LIKE '%?1%'",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    // Paginacion
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE '%?1%' OR perosna.apellido LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(String filtro, Pageable pageable);

//    Anotacion JPQL parametros nombrados
//    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
//    List<Persona> search1(@Param("filtro") String filtro);
}