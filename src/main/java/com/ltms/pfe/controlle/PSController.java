package com.ltms.pfe.controlle;

import com.ltms.pfe.model.PlantSection;
import com.ltms.pfe.service.PlantSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ps")
public class PSController {
    @Autowired
    private PlantSectionService service;

    @PostMapping("/add")
    public ResponseEntity<PlantSection> addPlantSection(@RequestBody PlantSection plantSection) {
        PlantSection newPlantSection = service.save(plantSection);
        return new ResponseEntity<>(newPlantSection, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlantSection>> getAllPlantSections() {
        List<PlantSection> plantSections = service.getAll();
        return new ResponseEntity<>(plantSections, HttpStatus.OK);
    }
    @GetMapping("/get/{name}")
    public ResponseEntity<PlantSection> getPlantSectionById(@PathVariable("name") String name) {
        PlantSection plantSection = service.getByName(name);
        return new ResponseEntity<>(plantSection, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlantSection> updatePlantSection(@PathVariable("id") long id, @RequestBody PlantSection plantSection) {
        plantSection.setId(id);
        PlantSection updatedPlantSection = service.update(plantSection);
        return new ResponseEntity<>(updatedPlantSection, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlantSection(@PathVariable("id") long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
