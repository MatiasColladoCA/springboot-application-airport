package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Ciudad;
import com.example.colladodemoprojectgradle.service.CiudadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/ciudades")
public class CiudadController extends BaseControllerImpl<Ciudad, CiudadServiceImpl> {
}