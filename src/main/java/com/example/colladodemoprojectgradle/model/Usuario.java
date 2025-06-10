package com.example.colladodemoprojectgradle.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Usuario extends Persona{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private String numeroUsuario;

    private String contraseñaUsuario;

    @Column(unique = true, nullable = false)
    private String correoElectronicoUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Consulta> consultas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "usuario_tarjeta",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "tarjeta_id")
    )
    private List<Tarjeta> tarjetas = new ArrayList<>();
}