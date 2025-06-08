package com.example.colladodemoprojectgradle.repository;


//import com.example.vuelos.model.Usuario;
import com.example.colladodemoprojectgradle.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {

    Optional<Usuario> findByCorreoElectronicoUsuario(String email);

    @Query("SELECT u FROM Usuario u WHERE u.numeroUsuario = :numeroUsuario")
    Optional<Usuario> findByNumeroUsuario(@Param("numeroUsuario") String numeroUsuario);
}