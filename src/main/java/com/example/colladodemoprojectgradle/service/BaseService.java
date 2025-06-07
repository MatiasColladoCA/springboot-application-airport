package com.example.colladodemoprojectgradle.service;

import com.example.colladodemoprojectgradle.model.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

//Metodos principales CRUD implementables en todos los servicios sin necesidad de declarar todos los métodos
//Recibe Entities
public interface BaseService<E extends Base, ID extends Serializable>{
    public List<E> findAll() throws Exception;
    public E findById(ID id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(ID id, E entity) throws Exception;
    public boolean delete(ID id) throws Exception;
    public Page<E> findAll(Pageable pageable) throws Exception;

}
