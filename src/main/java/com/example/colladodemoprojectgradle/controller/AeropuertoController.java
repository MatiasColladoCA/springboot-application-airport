package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.dto.AeropuertoDTO;
import com.example.colladodemoprojectgradle.model.Aeropuerto;
import com.example.colladodemoprojectgradle.service.AeropuertoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/aeropuertos")
public class AeropuertoController extends BaseControllerImpl<Aeropuerto, AeropuertoServiceImpl> {

//    @GetMapping("/{id}")
//    public ResponseEntity<AeropuertoDTO> obtenerAeropuerto(@PathVariable Long id) {
//        try {
//            Aeropuerto aeropuerto = servicio.findById(id);
//            if (aeropuerto == null) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok(AeropuertoDTO.convertirAeropuertoDTO(aeropuerto));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
}