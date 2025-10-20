package com.breaze.genomebankapi.service;

import com.breaze.genomebankapi.entity.FunctionEntity;
import com.breaze.genomebankapi.repository.FunctionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de funciones biológicas.
 */
@Service
public class FunctionService {

    private final FunctionRepository repository;

    public FunctionService(FunctionRepository repository) {
        this.repository = repository;
    }

    /**
     * 🔹 Listar todas las funciones biológicas.
     */
    public List<FunctionEntity> listar() {
        return repository.findAll();
    }

    /**
     * 🔹 Crear una nueva función biológica.
     */
    public FunctionEntity crear(FunctionEntity funcion) {
        return repository.save(funcion);
    }

    /**
     * 🔹 Obtener una función biológica por su ID.
     */
    public FunctionEntity obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * 🔹 Actualizar una función biológica existente.
     */
    public FunctionEntity actualizar(Integer id, FunctionEntity funcion) {
        FunctionEntity existente = repository.findById(id).orElseThrow();

        existente.setIdentificador(funcion.getIdentificador());
        existente.setNombre(funcion.getNombre());
        existente.setCategoria(funcion.getCategoria());

        return repository.save(existente);
    }

    /**
     * 🔹 Eliminar una función biológica por su ID.
     */
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
