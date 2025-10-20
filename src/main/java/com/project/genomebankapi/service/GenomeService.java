package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.Genome;
import com.project.genomebankapi.repository.GenomeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servicio para Genome: maneja la lógica CRUD básica.
 */
@Service
public class GenomeService {

    private final GenomeRepository repository;

    public GenomeService(GenomeRepository repository) {
        this.repository = repository;
    }

    /**
     * Listar todos los genomas.
     */
    public List<Genome> listar() {
        return repository.findAll();
    }

    /**
     * Crear un nuevo genoma.
     */
    public Genome crear(Genome g) {
        return repository.save(g);
    }

    /**
     * Obtener un genoma por su ID.
     */
    public Genome obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Actualizar un genoma existente.
     */
    public Genome actualizar(Long id, Genome g) {
        Genome existente = repository.findById(id).orElseThrow();
        existente.setChromosome(g.getChromosome());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
