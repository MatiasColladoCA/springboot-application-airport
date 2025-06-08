package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Tarifa;
//import com.example.vuelos.model.enums.ClaseServicio;
//import com.example.vuelos.repository.TarifaRepository;
import com.example.colladodemoprojectgradle.model.ClaseServicio;
import com.example.colladodemoprojectgradle.model.Tarifa;
import com.example.colladodemoprojectgradle.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TarifaServiceImpl extends BaseServiceImpl<Tarifa, Long> implements TarifaService {

    private final TarifaRepository tarifaRepository;

    @Autowired
    public TarifaServiceImpl(TarifaRepository tarifaRepository) {
        super(tarifaRepository);
        this.tarifaRepository = tarifaRepository;
    }

    @Override
    public List<Tarifa> findByVueloId(Long vueloId) throws Exception {
        try {
            return tarifaRepository.findByVueloId(vueloId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Tarifa> findByClaseTarifa(ClaseServicio clase) throws Exception {
        try {
            return tarifaRepository.findByClaseTarifa(clase);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}