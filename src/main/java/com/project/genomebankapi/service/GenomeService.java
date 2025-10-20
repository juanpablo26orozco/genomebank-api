package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.Genome;
import com.project.genomebankapi.repository.GenomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la entidad Genome.
 * Maneja la lógica CRUD y operaciones sobre genomas vinculados a especies.
 */
@Service
public class GenomeService {

    private final GenomeRepository repository;

    // Constructor con inyección de dependencia
    public GenomeService(GenomeRepository repository) {
        this.repository = repository;
    }

    /**
     * Listar todos los genomas.
     * @return lista de genomas
     */
    public List<Genome> listar() {
        return repository.findAll();
    }

    /**
     * Crear un nuevo genoma.
     * @param genome objeto Genome a guardar
     * @return el genoma creado
     */
    public Genome crear(Genome genome) {
        return repository.save(genome);
    }

    /**
     * Obtener un genoma por su ID.
     * @param id ID del genoma
     * @return el genoma si existe, null si no
     */
    public Genome obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Actualizar un genoma existente.
     * @param id ID del genoma a actualizar
     * @param genome objeto Genome con los datos nuevos
     * @return el genoma actualizado
     */
    public Genome actualizar(Integer id, Genome genome) {
        Optional<Genome> existenteOpt = repository.findById(id);
        if (existenteOpt.isEmpty()) {
            throw new RuntimeException("Genoma no encontrado con ID: " + id);
        }

        Genome existente = existenteOpt.get();
        // Actualizar la relación con Species
        existente.setSpecies(genome.getSpecies());

        return repository.save(existente);
    }

    /**
     * Eliminar un genoma por su ID.
     * @param id ID del genoma
     */
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
