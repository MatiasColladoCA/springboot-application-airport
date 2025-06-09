package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Ciudad;
import com.example.colladodemoprojectgradle.repository.BaseRepository;
import com.example.colladodemoprojectgradle.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl extends BaseServiceImpl<Ciudad, Long> implements CiudadService {
    @Autowired
    private CiudadRepository ciudadRepository;

    public CiudadServiceImpl(BaseRepository<Ciudad, Long> baseRepository, CiudadRepository ciudadRepository) {
        super(baseRepository);
        this.ciudadRepository = ciudadRepository;
    }
}
