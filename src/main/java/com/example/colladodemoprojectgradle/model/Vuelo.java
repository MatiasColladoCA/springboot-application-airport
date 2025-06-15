package com.example.colladodemoprojectgradle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(unique = true)//)//, nulable = false)
    private String numeroVuelo;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime salida;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime destino;

    @ManyToOne
    @JoinColumn(name = "avion_id")//, nulable = false)
    @JsonIgnore  // O usar @JsonBackReference si necesitas mostrar datos del avión
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "aerolinea_id")//, nulable = false)
    @JsonIgnore  // O usar @JsonBackReference si necesitas mostrar datos de aerolínea
    private Aerolinea aerolinea;

    @ManyToMany
    @JoinTable(
            name = "vuelo_aeropuertos",
            joinColumns = @JoinColumn(name = "vuelo_id"),
            inverseJoinColumns = @JoinColumn(name = "aeropuerto_id")
    )
    @JsonIgnore
    private Set<Aeropuerto> aeropuertos;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Tarifa> tarifas = new HashSet<>();
}
