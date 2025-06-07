package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.XLibro;
import com.example.colladodemoprojectgradle.service.XLibroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/libros")
public class XLibroController extends BaseControllerImpl<XLibro, XLibroServiceImpl> {
}