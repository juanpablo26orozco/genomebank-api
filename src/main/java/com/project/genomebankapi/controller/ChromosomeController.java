package com.project.genomebankapi.controller;

import com.project.genomebankapi.entity.Chromosome;
import com.project.genomebankapi.service.ChromosomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar operaciones sobre cromosomas.
 */
@RestController
@RequestMapping("/chromosome")
public class ChromosomeController {

    private final ChromosomeService service;

    public ChromosomeController(ChromosomeService service) {
        this.service = service;
    }

    /**
     * Lista todos los cromosomas o filtra por genoma si se pasa el parámetro.
     * Ejemplo: GET /cromosomas?genomaId=3
     */
    @GetMapping
    public List<Chromosome> listar(@RequestParam(required = false) Integer genomaId) {
        if (genomaId == null) {
            return service.listar();
        } else {
            return service.listarPorGenoma(genomaId);
        }
    }

    /**
     * Obtiene un cromosoma por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Chromosome> obtener(@PathVariable Integer id) {
        Chromosome cromosoma = service.obtener(id);
        if (cromosoma == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cromosoma);
    }

    /**
     * Crea un nuevo cromosoma.
     */
    @PostMapping
    public ResponseEntity<Chromosome> crear(@RequestBody Chromosome cromosoma) {
        return ResponseEntity.ok(service.crear(cromosoma));
    }

    /**
     * Actualiza un cromosoma existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Chromosome> actualizar(@PathVariable Integer id, @RequestBody Chromosome cromosoma) {
        return ResponseEntity.ok(service.actualizar(id, cromosoma));
    }

    /**
     * Elimina un cromosoma por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
