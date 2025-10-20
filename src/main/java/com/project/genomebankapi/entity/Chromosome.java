package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad Chromosome — representa un cromosoma con su nombre, longitud, secuencia y relación con un genoma.
 */
@Entity
@Table(name = "cromosoma")
public class Chromosome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "longitud", nullable = false)
    private Integer longitud;

    @Lob
    @Column(name = "secuencia", nullable = false, columnDefinition = "TEXT")
    private String secuencia;

    @ManyToOne
    @JoinColumn(name = "genoma_id", nullable = false)
    private Genome genoma;

    public Chromosome() {}

    // 🔹 Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getLongitud() { return longitud; }
    public void setLongitud(Integer longitud) { this.longitud = longitud; }

    public String getSecuencia() { return secuencia; }
    public void setSecuencia(String secuencia) { this.secuencia = secuencia; }

    public Genome getGenoma() { return genoma; }
    public void setGenoma(Genome genoma) { this.genoma = genoma; }
}
