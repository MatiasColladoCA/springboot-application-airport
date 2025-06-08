package com.example.colladodemoprojectgradle.repository;

//package com.example.vuelos.repository;

//import com.example.vuelos.model.Persona;
import com.example.colladodemoprojectgradle.model.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    List<Persona> findByNombrePersonaContainingOrApellidoPersonaContaining(
            String nombre, String apellido);

    @Query("SELECT p FROM Persona p WHERE p.dniPersona = :dni")
    Optional<Persona> findByDni(@Param("dni") String dni);
}