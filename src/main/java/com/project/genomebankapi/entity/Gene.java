package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad Gene: representa un gen con su posición, orientación y secuencia.
 * Tabla: gen
 */
@Entity
@Table(name = "gen")
public class Gene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "simbolo", length = 5, nullable = false)
    private String simbolo;

    @Column(name = "pos_inicio", nullable = false)
    private String posInicio;

    @Column(name = "pos_final", nullable = false)
    private String posFinal;

    @Column(name = "orientacion", nullable = false)
    private Boolean orientacion;

    @Lob
    @Column(name = "secuencia", nullable = false, columnDefinition = "TEXT")
    private String secuencia;

    // 🔗 Relación muchos-a-uno con la tabla Chromosome
    @ManyToOne
    @JoinColumn(name = "cromosoma_id", nullable = false)
    private Chromosome cromosoma;

    // ==============================
    // 🧬 Constructores
    // ==============================
    public Gene() {}

    // ==============================
    // ⚙️ Getters y Setters
    // ==============================
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

    public Chromosome getCromosoma() { return cromosoma; }
    public void setCromosoma(Chromosome cromosoma) { this.cromosoma = cromosoma; }
}
