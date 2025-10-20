package com.breaze.genomebankapi.repository;

import com.breaze.genomebankapi.entity.Genome;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GenomeRepository extends JpaRepository<Genome, Long> {
    List<Genome> findBySpeciesId(Long speciesId);
}
