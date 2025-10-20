package com.breaze.genomebankapi.service;

import com.breaze.genomebankapi.entity.GeneFunction;
import com.breaze.genomebankapi.repository.GeneFunctionRepository;
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
        return repository.findByGene_Id(Long.valueOf(geneId));
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
        repository.deleteById(Long.valueOf(id));
    }
}
