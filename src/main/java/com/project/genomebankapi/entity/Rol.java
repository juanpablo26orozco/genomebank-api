package com.project.genomebankapi.entity;

import jakarta.persistence.*;
import java.util.Set;

/**
 * Entidad Rol: representa un rol de usuario (ej. ADMIN, USER)
 * Tabla: rol
 */
@Entity
@Table(name = "rol") // nombre de la tabla en la BD
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreRol", nullable = false, unique = true, length = 255)
    private String nombreRol;

    // 🔗 Relación uno-a-muchos con Users
    @OneToMany(mappedBy = "rol")
    private Set<Users> usuarios;

    // ==============================
    // 🛠 Constructores
    // ==============================
    public Rol() {}

    // ==============================
    // ⚙️ Getters y Setters
    // ==============================
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }

    public Set<Users> getUsuarios() { return usuarios; }
    public void setUsuarios(Set<Users> usuarios) { this.usuarios = usuarios; }
}
