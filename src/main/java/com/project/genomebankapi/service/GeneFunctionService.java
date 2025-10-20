package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.GeneFunction;
import com.project.genomebankapi.repository.GeneFunctionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona las operaciones relacionadas con la asociación
 * entre genes y funciones biológicas.
 */
@Service
public class GeneFunctionService {

    private final GeneFunctionRepository geneFunctionRepository;

    public GeneFunctionService(GeneFunctionRepository geneFunctionRepository) {
        this.geneFunctionRepository = geneFunctionRepository;
    }

    /**
     * 🔹 Listar todas las funciones asociadas a un gen específico.
     * @param genId ID del gen
     * @return Lista de relaciones gene-función
     */
    public List<GeneFunction> listarPorGen(Integer genId) {
        return geneFunctionRepository.findByGen_Id(genId);
    }

    /**
     * 🔹 Crear una nueva relación entre gen y función.
     * @param geneFunction objeto GeneFunction con los datos a guardar
     * @return relación guardada
     */
    public GeneFunction crear(GeneFunction geneFunction) {
        return geneFunctionRepository.save(geneFunction);
    }

    /**
     * 🔹 Obtener una relación por su ID.
     * @param id ID de la relación
     * @return GeneFunction si existe
     */
    public Optional<GeneFunction> obtenerPorId(Integer id) {
        return geneFunctionRepository.findById(id);
    }

    /**
     * 🔹 Eliminar una relación gen-función.
     * @param id ID de la relación
     */
    public void eliminar(Integer id) {
        geneFunctionRepository.deleteById(id);
    }

    public GeneFunction obtener(Integer id) {
        return null;
    }
}
