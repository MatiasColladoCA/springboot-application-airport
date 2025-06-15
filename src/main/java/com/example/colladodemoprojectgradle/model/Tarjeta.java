package com.example.colladodemoprojectgradle.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "tarjeta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Tarjeta extends Base {
    @Column(unique = true)//, nulable = false)
    private String numeroTarjeta;

    @Enumerated(EnumType.STRING)
    private TipoTarjeta tipoTarjeta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")//, nulable = false)
    private Usuario usuario;
}