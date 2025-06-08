package com.example.colladodemoprojectgradle.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tarjetas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta extends Base {
    @Column(unique = true, nullable = false)
    private String numeroTarjeta;

    @Enumerated(EnumType.STRING)
    private TipoTarjeta tipoTarjeta;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}