package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public abstract class Persona extends Base {

//    @Column(nullable = false)
//    private Long id;
    @Column(nullable = false, unique = true)
    protected String dniPersona;

    @Column(nullable = false)
    protected String nombrePersona;

    @Column(nullable = false)
    protected String apellidoPersona;
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
