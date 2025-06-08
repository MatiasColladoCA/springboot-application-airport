package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pago extends Base {
    @Column(unique = true)
    private String numeroPago;
    private double cantidadPago;

    @OneToOne(mappedBy = "pago")
    private Reserva reserva;
}