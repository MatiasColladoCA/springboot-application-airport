package com.example.colladodemoprojectgradle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "nombre")//, nulable = false, unique = true)
    private String nombreAeropuerto;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")//, nulable = false)
    @JsonIgnore
    private Ciudad ciudad;

    @ManyToMany(mappedBy = "aeropuertos")
    @JsonIgnore
    private Set<Vuelo> vuelos = new HashSet<>();
}
