package com.breaze.genomebankapi.controller;

import com.breaze.genomebankapi.entity.Genome;
import com.breaze.genomebankapi.service.GenomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para Genome (solo relación con Chromosome).
 */
@RestController
@RequestMapping("/genomes")
public class GenomeController {

    private final GenomeService service;

    public GenomeController(GenomeService service) {
        this.service = service;
    }

    /**
     * Listar todos los genomas.
     */
    @GetMapping
    public List<Genome> listar() {
        return service.listar();
    }

    /**
     * Obtener un genoma por ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Genome> obtener(@PathVariable Long id) {
        Genome g = service.obtener(id);
        if (g == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(g);
    }

    /**
     * Crear un nuevo genoma.
     */
    @PostMapping
    public ResponseEntity<Genome> crear(@RequestBody Genome g) {
        return ResponseEntity.ok(service.crear(g));
    }

    /**
     * Actualizar un genoma existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Genome> actualizar(@PathVariable Long id, @RequestBody Genome g) {
        return ResponseEntity.ok(service.actualizar(id, g));
    }

    /**
     * Eliminar un genoma por ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
