package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad FunctionEntity: representa una función biológica con su identificador, nombre y categoría.
 */
@Entity
@Table(name = "functions")
public class FunctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "identificador", length = 32, nullable = false, unique = true)
    private String identificador;

    @Column(name = "nombre", length = 255, nullable = false)
    private String nombre;

    @Column(name = "categoria", length = 2, nullable = false)
    private String categoria;

    public FunctionEntity() {}

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
