package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vuelos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Vuelo extends Base {
    @Column(unique = true, nullable = false)
    private String numeroVuelo;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime salida;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime destino;

    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id", nullable = false)
    private Aerolinea aerolinea;

    @ManyToMany
    @JoinTable(
            name = "vuelo_aeropuertos",
            joinColumns = @JoinColumn(name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "aeropuerto_id")
    )
    private Set<Aeropuerto> aeropuertos;
//    private Set<Aeropuerto> aeropuertos = new HashSet<>();

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tarifa> tarifas = new HashSet<>();
}