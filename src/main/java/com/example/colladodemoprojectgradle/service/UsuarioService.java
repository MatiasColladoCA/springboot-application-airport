package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Usuario;
import com.example.colladodemoprojectgradle.model.Usuario;

import java.util.Optional;

public interface UsuarioService extends BaseService<Usuario, Long> {
    Optional<Usuario> findByEmail(String email) throws Exception;
}