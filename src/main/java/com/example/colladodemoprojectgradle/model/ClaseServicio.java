package com.example.colladodemoprojectgradle.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ClaseServicio {
    BUSINESS,
    TURISTA,
    ECONOMY; // Cambiar TURISTA a PREMIUM si corresponde

    // Método para evitar problemas con nombres en español
    @JsonValue
    public String toValue() {
        return this.name().toLowerCase();
    }
}
