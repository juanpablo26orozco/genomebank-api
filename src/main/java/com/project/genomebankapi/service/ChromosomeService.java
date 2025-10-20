package com.project.genomebankapi.service;

import com.project.genomebankapi.entity.Chromosome;
import com.project.genomebankapi.repository.ChromosomeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

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

    // 🔹 Listar cromosomas por gen
    public List<Chromosome> listarPorGene(Integer geneId) {
        return repository.findByGeneId(geneId);
    }

    // 🔹 Crear cromosoma
    public Chromosome crear(Chromosome c) {
        if (c.getLength() == null || c.getLength() <= 0) {
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
        Chromosome existente = repository.findById(id).orElseThrow();
        existente.setName(c.getName());
        existente.setLength(c.getLength());
        existente.setGene(c.getGene());
        return repository.save(existente);
    }

    // 🔹 Eliminar cromosoma
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
