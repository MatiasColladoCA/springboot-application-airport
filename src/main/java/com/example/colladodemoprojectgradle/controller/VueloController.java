package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Vuelo;
import com.example.colladodemoprojectgradle.service.VueloServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/vuelos")
public class VueloController extends BaseControllerImpl<Vuelo, VueloServiceImpl> {
}