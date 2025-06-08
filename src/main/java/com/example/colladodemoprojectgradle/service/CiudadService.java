package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;

//import com.example.vuelos.model.Ciudad;
import com.example.colladodemoprojectgradle.model.Ciudad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CiudadService extends BaseService<Ciudad, Long> {
    List<Ciudad> search(String filtro) throws Exception;
    Page<Ciudad> search(String filtro, Pageable pageable) throws Exception;
}