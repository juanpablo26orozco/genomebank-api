package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.Chromosome;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la entidad Chromosome.
 * Permite consultas automáticas basadas en el campo "genoma".
 */
public interface ChromosomeRepository extends JpaRepository<Chromosome, Integer> {

    // 🔹 Buscar cromosomas por ID del genoma asociado
    List<Chromosome> findByGenomaId(Integer genomaId);
}
