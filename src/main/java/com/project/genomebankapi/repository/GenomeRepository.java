package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.Genome;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio JPA para la entidad Genome.
 * Permite operaciones CRUD y consultas personalizadas sobre genomas.
 */
public interface GenomeRepository extends JpaRepository<Genome, Integer> {

    /**
     * Buscar todos los genomas asociados a una especie por su ID.
     * @param speciesId ID de la especie
     * @return lista de genomas pertenecientes a la especie
     */
    List<Genome> findBySpeciesId(Integer speciesId);
}
