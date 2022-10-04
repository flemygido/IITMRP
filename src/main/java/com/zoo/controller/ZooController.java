package com.zoo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.bean.Zoo;
import com.zoo.repository.ZooRepository;



@RestController
@RequestMapping("/api")
public class ZooController {

    @Autowired
    private ZooRepository zooRepository;


    @GetMapping("/zoo/")
    public List < Zoo > getZoo() {
        return zooRepository.findAll();
    }

    @GetMapping("/zoo/{id}")
    public ResponseEntity < Zoo > getById(
        @PathVariable(value = "id") Integer zooId) throws ResourceNotFoundException {
        Zoo user = zooRepository.findById(zooId)
            .orElseThrow(() -> new ResourceNotFoundException("zoo not found :: " + zooId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/zoo/")
    public Zoo createUser(@Validated @RequestBody Zoo zoo) {
        return zooRepository.save(zoo);
    }

    
}