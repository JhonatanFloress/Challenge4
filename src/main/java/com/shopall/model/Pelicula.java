package com.shopall.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 áéíóúÁÉÍÓÚñÑ!.,'-]+$", message = "El nombre contiene caracteres inválidos")
    private String nombre;

    @NotNull(message = "El campo 'disponible' no puede ser nulo")
    private Boolean disponible;

    public Pelicula() {}

    public Pelicula(String nombre, Boolean disponible) {
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}