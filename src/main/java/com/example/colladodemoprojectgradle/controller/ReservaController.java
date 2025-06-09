package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Reserva;
import com.example.colladodemoprojectgradle.service.ReservaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/reservas")
public class ReservaController extends BaseControllerImpl<Reserva, ReservaServiceImpl> {
}