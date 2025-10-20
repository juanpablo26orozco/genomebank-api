package com.project.genomebankapi.controller;

import com.project.genomebankapi.entity.Genome;
import com.project.genomebankapi.service.GenomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la entidad Genome.
 * Gestiona operaciones CRUD sobre genomas vinculados a especies.
 */
@RestController
@RequestMapping("/genomes")
public class GenomeController {

    private final GenomeService genomeService;

    // Constructor con inyección de dependencia
    public GenomeController(GenomeService genomeService) {
        this.genomeService = genomeService;
    }

    /**
     * Listar todos los genomas.
     * @return lista de genomas
     */
    @GetMapping
    public ResponseEntity<List<Genome>> listar() {
        List<Genome> genomes = genomeService.listar();
        return ResponseEntity.ok(genomes);
    }

    /**
     * Obtener un genoma por su ID.
     * @param id ID del genoma
     * @return el genoma si existe, 404 si no
     */
    @GetMapping("/{id}")
    public ResponseEntity<Genome> obtener(@PathVariable Integer id) {
        Genome genome = genomeService.obtener(id);
        if (genome == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genome);
    }

    /**
     * Crear un nuevo genoma.
     * @param genome objeto Genome recibido en el body
     * @return el genoma creado
     */
    @PostMapping
    public ResponseEntity<Genome> crear(@RequestBody Genome genome) {
        Genome creado = genomeService.crear(genome);
        return ResponseEntity.ok(creado);
    }

    /**
     * Actualizar un genoma existente por su ID.
     * @param id ID del genoma
     * @param genome objeto Genome con datos actualizados
     * @return el genoma actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Genome> actualizar(@PathVariable Integer id, @RequestBody Genome genome) {
        Genome actualizado = genomeService.actualizar(id, genome);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * Eliminar un genoma por su ID.
     * @param id ID del genoma
     * @return respuesta sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        genomeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
