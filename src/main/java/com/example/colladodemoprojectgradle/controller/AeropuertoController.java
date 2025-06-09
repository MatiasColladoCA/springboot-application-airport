package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Aeropuerto;
import com.example.colladodemoprojectgradle.service.AeropuertoServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/aeropuertos")
public class AeropuertoController extends BaseControllerImpl<Aeropuerto, AeropuertoServiceImpl> {
}