package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad GeneFunction: relación entre un gen y una función,
 * incluyendo la evidencia que respalda esa asociación.
 */
@Entity
@Table(name = "GeneFunction")
public class GeneFunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 🔗 FK hacia la tabla de genes
    @ManyToOne
    @JoinColumn(name = "gen_id", nullable = false)
    private Gene gen;

    // 🔗 FK hacia la tabla de funciones
    @ManyToOne
    @JoinColumn(name = "funcion_id", nullable = false)
    private FunctionEntity funcion;

    @Column(name = "evidencia", length = 255)
    private String evidencia;

    public GeneFunction() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gene getGen() {
        return gen;
    }

    public void setGen(Gene gen) {
        this.gen = gen;
    }

    public FunctionEntity getFuncion() {
        return funcion;
    }

    public void setFuncion(FunctionEntity funcion) {
        this.funcion = funcion;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }
}
