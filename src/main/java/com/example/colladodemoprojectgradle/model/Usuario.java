package com.example.colladodemoprojectgradle.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Persona{
    @Column(unique = true, nullable = false)
    private String numeroUsuario;
    private String contraseñaUsuario;

    @Column(unique = true, nullable = false)
    private String correoElectronicoUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;
}