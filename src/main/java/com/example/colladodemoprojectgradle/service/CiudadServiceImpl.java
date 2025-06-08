package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Ciudad;
//import com.example.vuelos.repository.CiudadRepository;
import com.example.colladodemoprojectgradle.model.Ciudad;
import com.example.colladodemoprojectgradle.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CiudadServiceImpl extends BaseServiceImpl<Ciudad, Long> implements CiudadService {

    private final CiudadRepository ciudadRepository;

    @Autowired
    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        super(ciudadRepository);
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<Ciudad> search(String filtro) throws Exception {
        try {
            return ciudadRepository.search(filtro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Ciudad> search(String filtro, Pageable pageable) throws Exception {
        try {
            return ciudadRepository.search(filtro, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}