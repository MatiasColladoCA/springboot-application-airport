package com.example.colladodemoprojectgradle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Reserva extends Base {
    @Column(unique = true)//, nulable = false)
    private String numeroReserva;

    @ManyToOne
    @JoinColumn(name = "vuelo_id")//, nulable = false)
    private Vuelo vuelo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pago_id", referencedColumnName = "id")
    private Pago pago;

    @ManyToOne
    @JoinColumn(name = "usuario_id")//, nulable = false)
    @JsonBackReference
    private Usuario usuario;
}