package com.example.colladodemoprojectgradle.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Consulta extends Base {
    @Column(unique = true)
    private String numeroConsulta;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "numero_usuario", referencedColumnName = "numeroUsuario")//, nulable = false)
    @JsonBackReference
    private Usuario usuario;

}
