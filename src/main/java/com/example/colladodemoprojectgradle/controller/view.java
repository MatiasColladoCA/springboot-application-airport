//package com.example.colladodemoprojectgradle.controller;
//
////package com.example.vuelos.controller.view;
////
////import com.example.vuelos.service.VueloService;
//import com.example.colladodemoprojectgradle.model.Reserva;
//import com.example.colladodemoprojectgradle.service.VueloService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@Controller
//public class VueloViewController {
//
//    private final VueloService vueloService;
//
//    @Autowired
//    public VueloViewController(VueloService vueloService) {
//        this.vueloService = vueloService;
//    }
//
//    @GetMapping("/vuelos")
//    public String listarVuelos(Model model) {
//        model.addAttribute("vuelos", vueloService.findAll());
//        return "vuelos/list";
//    }
//
//    @GetMapping("/vuelos/reservar/{id}")
//    public String formularioReserva(@PathVariable Long id, Model model) {
//        model.addAttribute("vuelo", vueloService.findByAeropuerto(id));
//        model.addAttribute("reserva", new Reserva());
//        return "vuelos/reserva";
//    }
//}