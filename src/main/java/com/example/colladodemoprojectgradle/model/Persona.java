package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "persona")
//@PrimaryKeyJoinColumn(name = "persona_id") // Para herencia JOINED
//@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona extends Base {
    @Column(nullable = false, unique = true)
    private String dniPersona;

    @Column(nullable = false)
    private String nombrePersona;

    @Column(nullable = false)
    private String apellidoPersona;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "persona_tarjetas",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "tarjeta_id")
    )
    private List<Tarjeta> tarjetas = new ArrayList<>();
}


//
//@Entity
//@Table(name="persona")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Audited
//public class Persona extends Base {
//    @Column(name="nombre")
//    private String nombre;
//    @Column(name="apellido")
//    private String apellido;
//    @Column(name="dni")
//    private int dni;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_domicilio")
//    private Domicilio domicilio;
//
//    //Composición
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //elimina la persona y los libros que le pertenecen
//    @JoinTable(
//            name = "persona_libro",
//            joinColumns = @JoinColumn(name = "persona_id"),
//            inverseJoinColumns = @JoinColumn(name = "libro_id")
//    )
//    private List<Libro> libros = new ArrayList<Libro>();
//
//}
