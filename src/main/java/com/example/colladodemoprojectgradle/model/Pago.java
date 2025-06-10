package com.example.colladodemoprojectgradle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Reserva reserva;
}