package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.GeneFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GeneFunctionRepository extends JpaRepository<GeneFunction, Long> {
    List<GeneFunction> findByGene_Id(Long geneId);
}
