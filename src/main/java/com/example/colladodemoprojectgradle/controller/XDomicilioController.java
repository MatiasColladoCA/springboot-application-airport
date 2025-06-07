package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.model.XDomicilio;
import com.example.colladodemoprojectgradle.service.XDomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilios")
public class XDomicilioController extends BaseControllerImpl<XDomicilio, XDomicilioServiceImpl> {
}