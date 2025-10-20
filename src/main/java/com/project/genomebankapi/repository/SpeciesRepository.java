package com.project.genomebankapi.repository;

import com.project.genomebankapi.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
}
