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

    //  Listar todas las especies
    public List<Species> listar() {
        return repository.findAll();
    }

    //  Obtener especie por ID
    public Species obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    //  Crear especie
    public Species crear(Species s) {
        if (s.getNombreCientifico() == null || s.getNombreCientifico().isBlank()) {
            throw new IllegalArgumentException("El nombre científico es obligatorio");
        }
        return repository.save(s);
    }

    //  Actualizar especie existente
    public Species actualizar(Integer id, Species s) {
        Species existente = repository.findById(id).orElseThrow();
        existente.setNombreCientifico(s.getNombreCientifico());
        existente.setNombreComun(s.getNombreComun());
        return repository.save(existente);
    }

    //  Eliminar especie
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
