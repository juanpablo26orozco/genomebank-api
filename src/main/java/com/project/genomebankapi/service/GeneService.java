package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.Gene;
import com.project.genomebankapi.repository.GeneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de Genes.
 */
@Service
public class GeneService {

    private final GeneRepository repository;

    public GeneService(GeneRepository repository) {
        this.repository = repository;
    }

    /**
     * ✅ Listar todos los genes.
     */
    public List<Gene> listar() {
        return repository.findAll();
    }

    /**
     * ✅ Listar genes filtrados por función.
     */
    public List<Gene> listarPorFuncion(Integer funcionId) {
        return repository.findByFuncionId(funcionId);
    }

    /**
     * ✅ Crear un nuevo gen.
     */
    public Gene crear(Gene g) {
        return repository.save(g);
    }

    /**
     * ✅ Obtener un gen por su ID.
     */
    public Gene obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * ✅ Actualizar un gen existente.
     */
    public Gene actualizar(Integer id, Gene g) {
        Gene existente = repository.findById(id).orElseThrow();

        existente.setSimbolo(g.getSimbolo());
        existente.setPosInicio(g.getPosInicio());
        existente.setPosFinal(g.getPosFinal());
        existente.setOrientacion(g.getOrientacion()); // ← 🔧 cambio aquí
        existente.setSecuencia(g.getSecuencia());
        existente.setFuncion(g.getFuncion());

        return repository.save(existente);
    }


    /**
     * ✅ Eliminar un gen por su ID.
     */
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }


    public Gene obtenerPorId(Integer id) {
        return obtener(id);
    }

}
