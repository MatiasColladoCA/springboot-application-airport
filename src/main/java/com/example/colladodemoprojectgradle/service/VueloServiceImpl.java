package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Vuelo;
//import com.example.vuelos.repository.VueloRepository;
import com.example.colladodemoprojectgradle.model.Vuelo;
import com.example.colladodemoprojectgradle.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VueloServiceImpl extends BaseServiceImpl<Vuelo, Long> implements VueloService {

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloServiceImpl(VueloRepository vueloRepository) {
        super(vueloRepository);
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<Vuelo> findByRangoFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception {
        try {
            return vueloRepository.findByRangoFechas(inicio, fin);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Vuelo> findByAeropuerto(Long aeropuertoId, Pageable pageable) throws Exception {
        try {
            return vueloRepository.findByAeropuerto(aeropuertoId, pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}