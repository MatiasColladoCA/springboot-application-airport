package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciudades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ciudad extends Base {
    @Column(nullable = false, unique = true)
    private String nombreCiudad;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aeropuerto> aeropuertos = new ArrayList<>();
}