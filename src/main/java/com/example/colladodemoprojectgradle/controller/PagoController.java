package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Pago;
import com.example.colladodemoprojectgradle.service.PagoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pagos")
public class PagoController extends BaseControllerImpl<Pago, PagoServiceImpl> {
}