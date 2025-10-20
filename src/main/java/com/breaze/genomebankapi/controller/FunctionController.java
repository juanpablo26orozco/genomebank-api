package com.breaze.genomebankapi.controller;

import com.breaze.genomebankapi.entity.FunctionEntity;
import com.breaze.genomebankapi.service.FunctionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de funciones biológicas.
 */
@RestController
@RequestMapping("/functions")
public class FunctionController {

    private final FunctionService service;

    public FunctionController(FunctionService service) {
        this.service = service;
    }

    /**
     * 🔹 Listar todas las funciones biológicas.
     */
    @GetMapping
    public ResponseEntity<List<FunctionEntity>> listar() {
        List<FunctionEntity> funciones = service.listar();
        return ResponseEntity.ok(funciones);
    }

    /**
     * 🔹 Obtener una función biológica por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<FunctionEntity> obtener(@PathVariable Integer id) {
        FunctionEntity funcion = service.obtener(id);
        if (funcion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcion);
    }

    /**
     * 🔹 Crear una nueva función biológica.
     */
    @PostMapping
    public ResponseEntity<FunctionEntity> crear(@RequestBody FunctionEntity funcion) {
        FunctionEntity creada = service.crear(funcion);
        return ResponseEntity.ok(creada);
    }

    /**
     * 🔹 Actualizar una función biológica existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<FunctionEntity> actualizar(@PathVariable Integer id, @RequestBody FunctionEntity funcion) {
        FunctionEntity actualizada = service.actualizar(id, funcion);
        return ResponseEntity.ok(actualizada);
    }

    /**
     * 🔹 Eliminar una función biológica por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
