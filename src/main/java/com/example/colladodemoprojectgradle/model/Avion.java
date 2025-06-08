package com.example.colladodemoprojectgradle.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aviones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avion extends Base implements Especificacion {
    @Column(unique = true, nullable = false)
    private String numeroAvion;

    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asiento> asientos = new ArrayList<>();

    private String tipoTurbina;
    private String tipoAvion;

    // Implementación de la interfaz
    @Override
    public String getTipoTurbina() {
        return tipoTurbina;
    }

    @Override
    public String getTipoAvion() {
        return tipoAvion;
    }
}

// Interfaz
interface Especificacion {
    String getTipoTurbina();
    String getTipoAvion();
}
