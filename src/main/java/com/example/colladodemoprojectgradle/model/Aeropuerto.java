package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aeropuerto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Aeropuerto extends Base {
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombreAeropuerto;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    @ManyToMany(mappedBy = "aeropuertos")
    private Set<Vuelo> vuelos = new HashSet<>();
}