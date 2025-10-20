package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.Gene;
import com.project.genomebankapi.repository.GeneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de Genes.
 * Realiza las operaciones de negocio y validación sobre la entidad Gene.
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
     * ✅ Listar genes filtrados por cromosoma.
     * @param cromosomaId ID del cromosoma asociado.
     */
    public List<Gene> listarPorCromosoma(Integer cromosomaId) {
        return repository.findByCromosomaId(cromosomaId);
    }

    /**
     * ✅ Obtener un gen por su ID.
     * @param id ID del gen
     * @return Gene encontrado o null si no existe.
     */
    public Gene obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * ✅ Crear un nuevo gen.
     */
    public Gene crear(Gene g) {
        return repository.save(g);
    }

    /**
     * ✅ Actualizar un gen existente.
     */
    public Gene actualizar(Integer id, Gene g) {
        Optional<Gene> opt = repository.findById(id);
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("No se encontró el gen con ID: " + id);
        }

        Gene existente = opt.get();
        existente.setSimbolo(g.getSimbolo());
        existente.setPosInicio(g.getPosInicio());
        existente.setPosFinal(g.getPosFinal());
        existente.setOrientacion(g.getOrientacion());
        existente.setSecuencia(g.getSecuencia());
        existente.setCromosoma(g.getCromosoma()); // 🔄 cambio clave aquí

        return repository.save(existente);
    }

    /**
     * ✅ Eliminar un gen por su ID.
     */
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    /**
     * ✅ Alias de obtener(), por compatibilidad.
     */
    public Gene obtenerPorId(Integer id) {
        return obtener(id);
    }
}
