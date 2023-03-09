package com.ltms.pfe.repo;

import com.ltms.pfe.model.PlantSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantSectionRepo extends JpaRepository<PlantSection,Long> {
    @Override
    Optional<PlantSection> findById(Long aLong);

    Optional<PlantSection> findByName(String name);
}
