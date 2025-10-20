package com.project.genomebankapi.controller;

import com.project.genomebankapi.entity.Gene;
import com.project.genomebankapi.entity.GeneFunction;
import com.project.genomebankapi.service.GeneFunctionService;
import com.project.genomebankapi.service.GeneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las asociaciones entre genes y funciones biológicas.
 * Endpoint base: /genes/{genId}/functions
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
     * ✅ Listar todas las funciones asociadas a un gen específico.
     */
    @GetMapping
    public ResponseEntity<List<GeneFunction>> listarPorGen(@PathVariable Integer genId) {
        List<GeneFunction> lista = geneFunctionService.listarPorGen(genId);
        return ResponseEntity.ok(lista);
    }

    /**
     * ✅ Obtener una relación específica entre gen y función por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<GeneFunction> obtener(@PathVariable Integer genId, @PathVariable Integer id) {
        GeneFunction relacion = geneFunctionService.obtener(id);
        if (relacion == null || relacion.getGen() == null || !relacion.getGen().getId().equals(genId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(relacion);
    }

    /**
     * ✅ Crear una nueva asociación entre un gen y una función.
     */
    @PostMapping
    public ResponseEntity<GeneFunction> crear(@PathVariable Integer genId, @RequestBody GeneFunction geneFunction) {
        Gene gen = geneService.obtenerPorId(genId);
        if (gen == null) {
            return ResponseEntity.badRequest().build();
        }

        geneFunction.setGen(gen);
        GeneFunction guardado = geneFunctionService.crear(geneFunction);
        return ResponseEntity.ok(guardado);
    }

    /**
     * ✅ Actualizar una relación existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<GeneFunction> actualizar(
            @PathVariable Integer genId,
            @PathVariable Integer id,
            @RequestBody GeneFunction geneFunction
    ) {
        Gene gen = geneService.obtenerPorId(genId);
        if (gen == null) {
            return ResponseEntity.badRequest().build();
        }

        geneFunction.setGen(gen);
        GeneFunction actualizado = geneFunctionService.obtener(id);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * ✅ Eliminar una relación específica entre un gen y una función.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer genId, @PathVariable Integer id) {
        GeneFunction relacion = geneFunctionService.obtener(id);
        if (relacion == null || relacion.getGen() == null || !relacion.getGen().getId().equals(genId)) {
            return ResponseEntity.notFound().build();
        }

        geneFunctionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
