package com.example.colladodemoprojectgradle.controller;

import com.example.colladodemoprojectgradle.dto.AvionDTO;
import com.example.colladodemoprojectgradle.dto.VueloDTO;
import com.example.colladodemoprojectgradle.model.Avion;
import com.example.colladodemoprojectgradle.model.Vuelo;
import com.example.colladodemoprojectgradle.service.VueloServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/vuelos")
public class VueloController extends BaseControllerImpl<Vuelo, VueloServiceImpl> {
//    public class VueloMapper {
//        public VueloDTO convertirAVueloDTO(Vuelo vuelo) {
//            Avion avion = vuelo.getAvion();
//            AvionDTO avionDTO = new AvionDTO(
//                    avion.getId(),
//                    avion.getNumeroAvion(),
//                    avion.getAsientos().size()
//            );
//
//            return new VueloDTO(
//                    vuelo.getId(),
//                    vuelo.getNumeroVuelo(),
//                    vuelo.getSalida(),
//                    vuelo.getDestino(),
//                    avionDTO
//            );
//        }
//    }

}