package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Aeropuerto;
import com.example.colladodemoprojectgradle.model.Aeropuerto;

import java.util.List;

public interface AeropuertoService extends BaseService<Aeropuerto, Long> {
    List<Aeropuerto> findByCiudadNombre(String ciudad) throws Exception;
}
