package com.breaze.genomebankapi.controller;

import com.breaze.genomebankapi.entity.Chromosome;
import com.breaze.genomebankapi.service.ChromosomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chromosomes")
public class ChromosomeController {

    private final ChromosomeService service;

    public ChromosomeController(ChromosomeService service) {
        this.service = service;
    }


    @GetMapping
    public List<Chromosome> listar(@RequestParam(required = false) Integer geneId) {
        if (geneId == null) return service.listar();
        return service.listarPorGene(geneId);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Chromosome> obtener(@PathVariable Integer id) {
        Chromosome c = service.obtener(id);
        if (c == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(c);
    }


    @PostMapping
    public ResponseEntity<Chromosome> crear(@RequestBody Chromosome c) {
        return ResponseEntity.ok(service.crear(c));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Chromosome> actualizar(@PathVariable Integer id, @RequestBody Chromosome c) {
        return ResponseEntity.ok(service.actualizar(id, c));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
