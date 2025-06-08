package com.example.colladodemoprojectgradle.repository;

//package com.example.vuelos.repository;

//import com.example.vuelos.model.Tarjeta;
//import com.example.vuelos.model.enums.TipoTarjeta;
import com.example.colladodemoprojectgradle.model.Tarjeta;
import com.example.colladodemoprojectgradle.model.TipoTarjeta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends BaseRepository<Tarjeta, Long> {

    List<Tarjeta> findByUsuarioId(Long usuarioId);

    List<Tarjeta> findByTipoTarjeta(TipoTarjeta tipo);
}
