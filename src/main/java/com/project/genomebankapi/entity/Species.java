package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad Species: representa una especie biológica registrada en el sistema.
 * Tabla en BD: especie
 */
@Entity
@Table(name = "especie")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreCientifico", length = 255, nullable = false, unique = true)
    private String nombreCientifico;

    @Column(name = "nombreComun", length = 255)
    private String nombreComun;

    public Species() {}

    // 🧩 Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }
}
