package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Tarjeta;
import com.example.colladodemoprojectgradle.service.TarjetaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/tarjetas")
public class TarjetaController extends BaseControllerImpl<Tarjeta, TarjetaServiceImpl> {
}