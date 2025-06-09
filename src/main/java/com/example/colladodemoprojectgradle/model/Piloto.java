package com.example.colladodemoprojectgradle.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "piloto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Piloto extends Persona {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String numeroPiloto;
}