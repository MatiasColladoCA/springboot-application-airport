package com.example.colladodemoprojectgradle.dto;

import com.example.colladodemoprojectgradle.model.Ciudad;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CiudadDTO {
    private Long id;
    private String nombreCiudad;

    public CiudadDTO convertirCiudadDTO(Ciudad ciudad) {
        return new CiudadDTO(
                ciudad.getId(),
                ciudad.getNombreCiudad()
        );
    }
}
