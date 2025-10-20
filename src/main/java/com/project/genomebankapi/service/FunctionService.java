package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.FunctionEntity;
import com.project.genomebankapi.repository.FunctionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de funciones biológicas.
 * Proporciona operaciones CRUD sobre FunctionEntity.
 */
@Service
public class FunctionService {

    private final FunctionRepository repository;

    // Constructor con inyección de dependencia
    public FunctionService(FunctionRepository repository) {
        this.repository = repository;
    }

    /**
     * Listar todas las funciones biológicas.
     * @return lista de FunctionEntity
     */
    public List<FunctionEntity> listar() {
        return repository.findAll();
    }

    /**
     * Crear una nueva función biológica.
     * @param funcion objeto FunctionEntity a crear
     * @return FunctionEntity creada
     */
    public FunctionEntity crear(FunctionEntity funcion) {
        return repository.save(funcion);
    }

    /**
     * Obtener una función biológica por su ID.
     * @param id ID de la función
     * @return FunctionEntity encontrada o null si no existe
     */
    public FunctionEntity obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Actualizar una función biológica existente.
     * @param id ID de la función a actualizar
     * @param funcion objeto FunctionEntity con los datos nuevos
     * @return FunctionEntity actualizada
     */
    public FunctionEntity actualizar(Integer id, FunctionEntity funcion) {
        Optional<FunctionEntity> existenteOpt = repository.findById(id);
        if (existenteOpt.isEmpty()) {
            throw new RuntimeException("Función biológica no encontrada con ID: " + id);
        }

        FunctionEntity existente = existenteOpt.get();
        existente.setIdentificador(funcion.getIdentificador());
        existente.setNombre(funcion.getNombre());
        existente.setCategoria(funcion.getCategoria());

        return repository.save(existente);
    }

    /**
     * Eliminar una función biológica por su ID.
     * @param id ID de la función
     */
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
