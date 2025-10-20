package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad GeneFunction: representa la relación entre un gen y una función biológica,
 * junto con la evidencia que respalda esa asociación.
 *
 * Tabla: gen_funcion
 */
@Entity
@Table(name = "gen_funcion")
public class GeneFunction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 🔗 FK hacia la tabla "gen"
    @ManyToOne
    @JoinColumn(name = "gen_id", nullable = false)
    private Gene gen;

    // 🔗 FK hacia la tabla "funcion"
    @ManyToOne
    @JoinColumn(name = "funcion_id", nullable = false)
    private FunctionEntity funcion;

    // Evidencia asociada a la relación
    @Column(name = "evidencia", length = 255)
    private String evidencia;

    // Constructor vacío requerido por JPA
    public GeneFunction() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Gene getGen() { return gen; }
    public void setGen(Gene gen) { this.gen = gen; }

    public FunctionEntity getFuncion() { return funcion; }
    public void setFuncion(FunctionEntity funcion) { this.funcion = funcion; }

    public String getEvidencia() { return evidencia; }
    public void setEvidencia(String evidencia) { this.evidencia = evidencia; }
}
