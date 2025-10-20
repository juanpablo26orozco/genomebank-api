package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.FunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad FunctionEntity.
 * Permite realizar operaciones CRUD sobre la tabla 'functions'.
 */
@Repository
public interface FunctionRepository extends JpaRepository<FunctionEntity, Integer> {
    // Se pueden agregar métodos personalizados si se necesitan más adelante.
}
