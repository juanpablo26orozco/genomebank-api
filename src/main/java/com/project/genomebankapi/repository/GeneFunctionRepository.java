package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.GeneFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositorio JPA para la entidad GeneFunction.
 * Permite acceder a las relaciones entre genes y funciones biológicas.
 */
public interface GeneFunctionRepository extends JpaRepository<GeneFunction, Integer> {

    /**
     * 🔹 Busca todas las relaciones según el ID del gen.
     * Equivale a: SELECT * FROM gen_funcion WHERE gen_id = :genId
     *
     * @param genId ID del gen
     * @return Lista de relaciones entre ese gen y sus funciones
     */
    List<GeneFunction> findByGen_Id(Integer genId);
}
