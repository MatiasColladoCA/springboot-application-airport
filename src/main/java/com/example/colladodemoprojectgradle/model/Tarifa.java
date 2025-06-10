package com.example.colladodemoprojectgradle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "tarifas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Tarifa extends Base {

    @Column(unique = true, nullable = false)
    private String numeroTarifa;

    private double impuestoTarifa;
    private double precioTarifa;

    @Enumerated(EnumType.STRING)
    private ClaseServicio claseTarifa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vuelo_id", nullable = false)
    @JsonBackReference
    private Vuelo vuelo;
}



