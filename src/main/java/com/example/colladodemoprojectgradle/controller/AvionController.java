package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Avion;
import com.example.colladodemoprojectgradle.service.AvionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/aviones")
public class AvionController extends BaseControllerImpl<Avion, AvionServiceImpl> {
}