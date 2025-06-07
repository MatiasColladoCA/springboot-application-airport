package com.example.colladodemoprojectgradle.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Table;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa una aerolínea en el sistema.
 */
@Entity
@Table(name="aerolinea")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Aerolinea extends Base {

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombreAerolinea;

    // Relación uno a muchos con Vuelo (opcional por ahora)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "aerolinea_vuelo",
            joinColumns = @JoinColumn(name = "aerolinea_id"),
            inverseJoinColumns = @JoinColumn(name = "vuelo_id")
    )
    private List<Vuelo> vuelos = new ArrayList<>();
}