package com.project.genomebankapi.controller;

import com.project.genomebankapi.entity.Gene;
import com.project.genomebankapi.service.GeneService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la entidad Gene.
 * Permite listar, obtener, crear, actualizar y eliminar genes.
 */
@RestController
@RequestMapping("/genes")
public class GeneController {

    private final GeneService service;

    public GeneController(GeneService service) {
        this.service = service;
    }

    /**
     * ✅ Listar todos los genes o filtrar por función si se pasa funcionId.
     */
    @GetMapping
    public List<Gene> listar(@RequestParam(required = false) Integer funcionId) {
        if (funcionId == null) {
            return service.listar();
        }
        return service.listarPorFuncion(funcionId);
    }

    /**
     * ✅ Obtener un gen por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Gene> obtener(@PathVariable Integer id) {
        Gene g = service.obtener(id);
        if (g == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(g);
    }

    /**
     * ✅ Crear un nuevo gen.
     */
    @PostMapping
    public ResponseEntity<Gene> crear(@RequestBody Gene g) {
        Gene nuevo = service.crear(g);
        return ResponseEntity.ok(nuevo);
    }

    /**
     * ✅ Actualizar un gen existente por su ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Gene> actualizar(@PathVariable Integer id, @RequestBody Gene g) {
        Gene actualizado = service.actualizar(id, g);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * ✅ Eliminar un gen por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
