package com.breaze.genomebankapi.controller;

import com.breaze.genomebankapi.entity.Gene;
import com.breaze.genomebankapi.entity.GeneFunction;
import com.breaze.genomebankapi.service.GeneFunctionService;
import com.breaze.genomebankapi.service.GeneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las asociaciones entre genes y funciones.
 */
@RestController
@RequestMapping("/genes/{genId}/functions")
public class GeneFunctionController {

    private final GeneFunctionService geneFunctionService;
    private final GeneService geneService;

    public GeneFunctionController(GeneFunctionService geneFunctionService, GeneService geneService) {
        this.geneFunctionService = geneFunctionService;
        this.geneService = geneService;
    }

    /**
     * 🔹 Lista todas las funciones asociadas a un gen específico.
     */
    @GetMapping
    public ResponseEntity<List<GeneFunction>> listarPorGen(@PathVariable Integer genId) {
        List<GeneFunction> lista = geneFunctionService.listarPorGen(genId);
        return ResponseEntity.ok(lista);
    }

    /**
     * 🔹 Crea una nueva asociación entre un gen y una función.
     */
    @PostMapping
    public ResponseEntity<GeneFunction> crear(@PathVariable Integer genId, @RequestBody GeneFunction geneFunction) {
        // Asociar el gen usando su ID
        Gene gen = geneService.obtenerPorId(genId);
        geneFunction.setGen(gen);

        GeneFunction guardado = geneFunctionService.crear(geneFunction);
        return ResponseEntity.ok(guardado);
    }

    /**
     * 🔹 Elimina una relación específica entre un gen y una función.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer genId, @PathVariable Integer id) {
        geneFunctionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
