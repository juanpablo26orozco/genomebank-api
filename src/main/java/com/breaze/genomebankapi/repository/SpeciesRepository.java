package com.breaze.genomebankapi.repository;

import com.breaze.genomebankapi.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {


    List<Species> findByGenomeId(Integer genomeId);
}
