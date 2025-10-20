package com.project.genomebankapi.controller;

import com.project.genomebankapi.entity.FunctionEntity;
import com.project.genomebankapi.service.FunctionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de funciones biológicas.
 * Permite operaciones CRUD sobre la entidad FunctionEntity.
 */
@RestController
@RequestMapping("/functions")
public class FunctionController {

    private final FunctionService functionService;

    // Constructor con inyección de dependencia
    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    /**
     * Listar todas las funciones biológicas.
     * @return lista de FunctionEntity
     */
    @GetMapping
    public ResponseEntity<List<FunctionEntity>> listar() {
        List<FunctionEntity> funciones = functionService.listar();
        return ResponseEntity.ok(funciones);
    }

    /**
     * Obtener una función biológica por su ID.
     * @param id ID de la función
     * @return FunctionEntity encontrada o 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<FunctionEntity> obtener(@PathVariable Integer id) {
        FunctionEntity funcion = functionService.obtener(id);
        if (funcion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funcion);
    }

    /**
     * Crear una nueva función biológica.
     * @param funcion FunctionEntity a crear
     * @return FunctionEntity creada
     */
    @PostMapping
    public ResponseEntity<FunctionEntity> crear(@RequestBody FunctionEntity funcion) {
        FunctionEntity creada = functionService.crear(funcion);
        return ResponseEntity.ok(creada);
    }

    /**
     * Actualizar una función biológica existente.
     * @param id ID de la función a actualizar
     * @param funcion FunctionEntity con los datos actualizados
     * @return FunctionEntity actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<FunctionEntity> actualizar(@PathVariable Integer id, @RequestBody FunctionEntity funcion) {
        FunctionEntity actualizada = functionService.actualizar(id, funcion);
        return ResponseEntity.ok(actualizada);
    }

    /**
     * Eliminar una función biológica por su ID.
     * @param id ID de la función
     * @return ResponseEntity sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        functionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
