package com.zoo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.bean.Animals;
import com.zoo.repository.AnimalRepository;
import com.zoo.repository.ZooRepository;

@RestController
public class AnimalsController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ZooRepository zooRepository;

    @GetMapping("/zoos/{zooId}/animals")
    public List < Animals > getAnimalByZoo(@PathVariable(value = "zooId") Integer zooId) {
        return animalRepository.findByZooId(zooId);
    }

    @PostMapping("/zoos/{zooId}/animals")
    public Animals createCourse(@PathVariable(value = "zooId") Integer zooId,
        @Validated @RequestBody Animals animal) throws ResourceNotFoundException {
        return zooRepository.findById(zooId).map(zoo -> {
            animal.setZoo(zoo);
            return animalRepository.save(animal);
        }).orElseThrow(() -> new ResourceNotFoundException("zoo not found"));
    }

   
}