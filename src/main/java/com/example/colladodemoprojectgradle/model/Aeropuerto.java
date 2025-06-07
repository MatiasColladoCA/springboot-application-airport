package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "aeropuerto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aeropuerto extends Base {
    @Column(nullable = false, unique = true)
    private String nombreAeropuerto;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    @ManyToMany(mappedBy = "aeropuertos")
    private Set<Vuelo> vuelos = new HashSet<>();
}