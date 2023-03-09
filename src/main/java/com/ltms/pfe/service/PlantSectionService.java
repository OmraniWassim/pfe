package com.ltms.pfe.service;

import com.ltms.pfe.model.PlantSection;
import com.ltms.pfe.repo.PlantSectionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlantSectionService {
    private final PlantSectionRepo repository;
    public PlantSection save(PlantSection plantSection) {
        return repository.save(plantSection);
    }

    public List<PlantSection> getAll() {
        return repository.findAll();
    }

    public PlantSection getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public PlantSection update(PlantSection plantSection) {
        PlantSection existingPlantSection = repository.findById(plantSection.getId()).orElse(null);
        if (existingPlantSection != null) {
            existingPlantSection.setDescription(plantSection.getDescription());
            existingPlantSection.setName(plantSection.getName());
            existingPlantSection.setEmplacement(plantSection.getEmplacement());
            existingPlantSection.setManager(plantSection.getManager());
            existingPlantSection.setRsponsableRH(plantSection.getRsponsableRH());
            existingPlantSection.setOrganisation(plantSection.getOrganisation());
        }
        return repository.save(existingPlantSection);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}



