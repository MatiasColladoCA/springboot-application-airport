package com.example.colladodemoprojectgradle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciudades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Ciudad extends Base {
    @Column(nullable = false, unique = true)
    private String nombreCiudad;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Aeropuerto> aeropuertos = new ArrayList<>();
}