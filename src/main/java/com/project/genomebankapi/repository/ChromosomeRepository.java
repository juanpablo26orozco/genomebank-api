package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.Chromosome;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChromosomeRepository extends JpaRepository<Chromosome, Integer> {
    List<Chromosome> findByGeneId(Integer geneId);
}
