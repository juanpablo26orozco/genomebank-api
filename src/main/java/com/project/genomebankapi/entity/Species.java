package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad Species: representa una especie biológica asociada a un genoma.
 */
@Entity
@Table(name = "species")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreCientifico", length = 255, nullable = false, unique = true)
    private String nombreCientifico;

    @Column(name = "nombreComun", length = 255)
    private String nombreComun;

    // 🔗 Relación muchos-a-uno con Genome (según FK en tu BD)
    @ManyToOne
    @JoinColumn(name = "genoma_id", nullable = false)
    private Genome genome;

    public Species() {}

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombreCientifico() { return nombreCientifico; }
    public void setNombreCientifico(String nombreCientifico) { this.nombreCientifico = nombreCientifico; }

    public String getNombreComun() { return nombreComun; }
    public void setNombreComun(String nombreComun) { this.nombreComun = nombreComun; }

    public Genome getGenome() { return genome; }
    public void setGenome(Genome genome) { this.genome = genome; }
}
