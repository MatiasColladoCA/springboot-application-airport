package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.Aerolinea;
import com.example.colladodemoprojectgradle.service.AerolineaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/aerolineas")
public class AerolineaController extends BaseControllerImpl<Aerolinea, AerolineaServiceImpl> {
}
