package com.example.colladodemoprojectgradle.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "piloto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Piloto extends Persona {
    @Column(unique = true, nullable = false)
    private String numeroPiloto;
}