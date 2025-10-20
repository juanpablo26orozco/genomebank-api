package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.Gene;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la entidad Gene.
 * Proporciona operaciones CRUD y consultas personalizadas.
 */
public interface GeneRepository extends JpaRepository<Gene, Integer> {
    List<Gene> findByCromosomaId(Integer cromosomaId);
}
