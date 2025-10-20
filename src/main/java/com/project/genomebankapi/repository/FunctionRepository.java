package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.FunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad FunctionEntity.
 * Gestiona operaciones CRUD sobre la tabla 'funcion'.
 *
 * NOTA: La tabla en la base de datos se llama 'funcion', no 'functions'.
 */
@Repository
public interface FunctionRepository extends JpaRepository<FunctionEntity, Integer> {

    /**
     * Aquí se pueden agregar consultas personalizadas si se necesitan,
     * por ejemplo: findByIdentificador(String identificador) o findByCategoria(String categoria)
     */
}
