package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.GeneFunction;
import com.project.genomebankapi.repository.GeneFunctionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servicio para la relación Gene-Function.
 */
@Service
public class GeneFunctionService {

    private final GeneFunctionRepository repository;

    public GeneFunctionService(GeneFunctionRepository repository) {
        this.repository = repository;
    }

    /**
     *  Listar relaciones por ID del gen.
     */
    public List<GeneFunction> listarPorGen(Integer geneId) {
        return repository.findByGen_Id(geneId);
    }

    /**
     *  Crear una nueva relación gen-función.
     */
    public GeneFunction crear(GeneFunction gf) {
        return repository.save(gf);
    }

    /**
     *  Eliminar una relación por ID.
     */
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
