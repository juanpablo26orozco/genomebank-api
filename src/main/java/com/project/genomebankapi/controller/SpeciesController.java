package com.project.genomebankapi.controller;

import com.project.genomebankapi.entity.Species;
import com.project.genomebankapi.service.SpeciesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar Species.
 */
@RestController
@RequestMapping("/species")
public class SpeciesController {

    private final SpeciesService service;

    public SpeciesController(SpeciesService service) {
        this.service = service;
    }

    //  Listar todas las especies
    @GetMapping
    public List<Species> listar() {
        return service.listar();
    }

    //  Obtener especie por ID
    @GetMapping("/{id}")
    public ResponseEntity<Species> obtener(@PathVariable Integer id) {
        Species s = service.obtener(id);
        if (s == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(s);
    }

    //  Crear nueva especie
    @PostMapping
    public ResponseEntity<Species> crear(@RequestBody Species s) {
        Species nueva = service.crear(s);
        return ResponseEntity.ok(nueva);
    }

    //  Actualizar especie
    @PutMapping("/{id}")
    public ResponseEntity<Species> actualizar(@PathVariable Integer id, @RequestBody Species s) {
        Species actualizada = service.actualizar(id, s);
        return ResponseEntity.ok(actualizada);
    }

    //  Eliminar especie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
