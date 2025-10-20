package com.project.genomebankapi.entity;

import jakarta.persistence.*;

/**
 * Entidad Users: representa un usuario de la aplicación.
 * Tabla: usuario
 */
@Entity
@Table(name = "usuario") // nombre de la tabla en la base de datos
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "contra_hashed", nullable = false, length = 255)
    private String contraHashed;

    //  Relación muchos-a-uno con Rol
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    // ==============================
    //  Constructores
    // ==============================
    public Users() {}

    // ==============================
    //  Getters y Setters
    // ==============================
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContraHashed() { return contraHashed; }
    public void setContraHashed(String contraHashed) { this.contraHashed = contraHashed; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
}
