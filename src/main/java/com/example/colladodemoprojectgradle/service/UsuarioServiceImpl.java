package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Usuario;
//import com.example.vuelos.repository.UsuarioRepository;
import com.example.colladodemoprojectgradle.model.Usuario;
import com.example.colladodemoprojectgradle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> findByNumero(int numero) throws Exception {
        try {
            return usuarioRepository.findByNumeroUsuario(numero);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}