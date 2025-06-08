package com.example.colladodemoprojectgradle.repository;

//package com.example.vuelos.repository;

//import com.example.vuelos.model.Asiento;
//import com.example.vuelos.model.enums.ClaseServicio;
import com.example.colladodemoprojectgradle.model.Asiento;
import com.example.colladodemoprojectgradle.model.ClaseServicio;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsientoRepository extends BaseRepository<Asiento, Long> {

    List<Asiento> findByAvionId(Long avionId);

    List<Asiento> findByClaseAsiento(ClaseServicio clase);
}