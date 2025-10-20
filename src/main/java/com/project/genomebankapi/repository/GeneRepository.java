package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.Gene;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio para la entidad Gene.
 */
public interface GeneRepository extends JpaRepository<Gene, Integer> {

    /**
     * ✅ Busca genes por el ID de su función asociada.
     */
    List<Gene> findByFuncionId(Integer funcionId);
}
