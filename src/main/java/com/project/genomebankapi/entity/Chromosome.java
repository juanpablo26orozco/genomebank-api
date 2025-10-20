package com.project.genomebankapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chromosomes")
public class Chromosome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String name;

    @Column(name = "longitud", nullable = false)
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "gen_id", nullable = false)
    private Gene gene;

    public Chromosome() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getLength() { return length; }
    public void setLength(Integer length) { this.length = length; }

    public Gene getGene() { return gene; }
    public void setGene(Gene gene) { this.gene = gene; }
}

