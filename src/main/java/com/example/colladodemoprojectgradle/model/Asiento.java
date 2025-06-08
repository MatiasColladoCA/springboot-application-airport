package com.example.colladodemoprojectgradle.model;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "asientos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Asiento extends Base {

    private int filaAsiento;

    @Column(length = 2)
    private String letraAsiento; // Usar String para soportar "A", "B", "AA", etc.

    @Enumerated(EnumType.STRING)
    private ClaseServicio claseAsiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avion_id", nullable = false)
    private Avion avion;

    private boolean ocupado = false;
}