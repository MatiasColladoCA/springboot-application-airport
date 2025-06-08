package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Pago extends Base {
    @Column(unique = true)
    private String numeroPago;
    private double cantidadPago;

    @OneToOne(mappedBy = "pago")
    private Reserva reserva;
}