package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.Chromosome;
import com.project.genomebankapi.repository.ChromosomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los cromosomas.
 */
@Service
public class ChromosomeService {

    private final ChromosomeRepository repository;

    public ChromosomeService(ChromosomeRepository repository) {
        this.repository = repository;
    }

    // 🔹 Listar todos los cromosomas
    public List<Chromosome> listar() {
        return repository.findAll();
    }

    // 🔹 Listar cromosomas por genoma
    public List<Chromosome> listarPorGenoma(Integer genomaId) {
        return repository.findByGenomaId(genomaId);
    }

    // 🔹 Crear cromosoma
    public Chromosome crear(Chromosome c) {
        if (c.getLongitud() == null || c.getLongitud() <= 0) {
            throw new IllegalArgumentException("La longitud del cromosoma debe ser mayor que cero");
        }
        return repository.save(c);
    }

    // 🔹 Obtener cromosoma por ID
    public Chromosome obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }

    // 🔹 Actualizar cromosoma existente
    public Chromosome actualizar(Integer id, Chromosome c) {
        Chromosome existente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cromosoma no encontrado con ID: " + id));

        existente.setNombre(c.getNombre());
        existente.setLongitud(c.getLongitud());
        existente.setSecuencia(c.getSecuencia());
        existente.setGenoma(c.getGenoma());

        return repository.save(existente);
    }

    // 🔹 Eliminar cromosoma
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar: cromosoma no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }
}
