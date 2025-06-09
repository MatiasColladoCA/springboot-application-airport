package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Vuelo;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import com.example.colladodemoprojectgradle.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloServiceImpl extends BaseServiceImpl<Vuelo, Long> implements VueloService {
    @Autowired
    private VueloRepository vueloRepository;

    public VueloServiceImpl(BaseRepository<Vuelo, Long> baseRepository, VueloRepository vueloRepository) {
        super(baseRepository);
        this.vueloRepository = vueloRepository;
    }
}
