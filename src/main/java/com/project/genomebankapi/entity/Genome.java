package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad Genome: representa un genoma vinculado a una especie.
 * Tabla: genoma
 * Campos: id (PK), especie_id (FK)
 */
@Entity
@Table(name = "genoma")
public class Genome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK hacia la tabla species
    @ManyToOne
    @JoinColumn(name = "especie_id", nullable = false)
    private Species species;

    // Constructor vacío
    public Genome() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
