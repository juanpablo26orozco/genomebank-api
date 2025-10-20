package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.Species;
import com.project.genomebankapi.repository.SpeciesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servicio para Species: validaciones y acceso al repositorio.
 */
@Service
public class SpeciesService {

    private final SpeciesRepository repository;

    public SpeciesService(SpeciesRepository repository) {
        this.repository = repository;
    }

    /**
     * Listar todas las especies.
     */
    public List<Species> listar() {
        return repository.findAll();
    }

    /**
     * Listar especies filtradas por ID de genoma.
     */
    public List<Species> listarPorGenome(Integer genomeId) {
        return repository.findByGenomeId(genomeId);
    }

    /**
     * Obtener una especie por su ID.
     */
    public Species obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Crear una nueva especie.
     */
    public Species crear(Species s) {
        return repository.save(s);
    }

    /**
     * Actualizar una especie existente.
     */
    public Species actualizar(Integer id, Species s) {
        Species existente = repository.findById(id).orElseThrow();
        existente.setNombreCientifico(s.getNombreCientifico());
        existente.setNombreComun(s.getNombreComun());
        existente.setGenome(s.getGenome());
        return repository.save(existente);
    }

    /**
     * Eliminar una especie por su ID.
     */
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
