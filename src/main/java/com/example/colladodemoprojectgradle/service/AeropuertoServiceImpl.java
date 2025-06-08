package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Aeropuerto;
//import com.example.vuelos.repository.AeropuertoRepository;
import com.example.colladodemoprojectgradle.model.Aeropuerto;
import com.example.colladodemoprojectgradle.repository.AeropuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AeropuertoServiceImpl extends BaseServiceImpl<Aeropuerto, Long> implements AeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;

    @Autowired
    public AeropuertoServiceImpl(AeropuertoRepository aeropuertoRepository) {
        super(aeropuertoRepository);
        this.aeropuertoRepository = aeropuertoRepository;
    }

    @Override
    public List<Aeropuerto> findByCiudadNombre(String ciudad) throws Exception {
        try {
            return aeropuertoRepository.findByCiudad(ciudad);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}