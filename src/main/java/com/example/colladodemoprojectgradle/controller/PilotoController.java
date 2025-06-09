package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Piloto;
import com.example.colladodemoprojectgradle.service.PilotoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pilotos")
public class PilotoController extends BaseControllerImpl<Piloto, PilotoServiceImpl> {
}