package com.breaze.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad Genome: representa un genoma vinculado a un cromosoma.
 * Tabla: genomes
 * Campos: id (PK), cromosoma_id (FK)
 */
@Entity
@Table(name = "genomes")
public class Genome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK hacia la tabla chromosomes
    @ManyToOne
    @JoinColumn(name = "cromosoma_id", nullable = false)
    private Chromosome chromosome;

    public Genome() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Chromosome getChromosome() {
        return chromosome;
    }

    public void setChromosome(Chromosome chromosome) {
        this.chromosome = chromosome;
    }
}
