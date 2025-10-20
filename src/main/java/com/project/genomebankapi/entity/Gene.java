package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad Gene: representa un gen con su posición, orientación y secuencia.
 * Tabla: genes
 */
@Entity
@Table(name = "genes")
public class Gene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "simbolo", length = 5, nullable = false)
    private String simbolo;

    @Column(name = "posInicio", columnDefinition = "CHAR(1)", nullable = false)
    private String posInicio;

    @Column(name = "posFinal", columnDefinition = "CHAR(1)", nullable = false)
    private String posFinal;

    @Column(name = "orientacion", nullable = false)
    private Boolean orientacion;

    @Lob
    @Column(name = "secuencia", nullable = false, columnDefinition = "TEXT")
    private String secuencia;

    // 🔗 Relación muchos-a-uno con la tabla GeneFunction
    @ManyToOne
    @JoinColumn(name = "funcionId", nullable = false)
    private GeneFunction funcion;

    public Gene() {}

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getSimbolo() { return simbolo; }
    public void setSimbolo(String simbolo) { this.simbolo = simbolo; }

    public String getPosInicio() { return posInicio; }
    public void setPosInicio(String posInicio) { this.posInicio = posInicio; }

    public String getPosFinal() { return posFinal; }
    public void setPosFinal(String posFinal) { this.posFinal = posFinal; }

    public Boolean getOrientacion() { return orientacion; }
    public void setOrientacion(Boolean orientacion) { this.orientacion = orientacion; }

    public String getSecuencia() { return secuencia; }
    public void setSecuencia(String secuencia) { this.secuencia = secuencia; }

    public GeneFunction getFuncion() { return funcion; }
    public void setFuncion(GeneFunction funcion) { this.funcion = funcion; }
}
