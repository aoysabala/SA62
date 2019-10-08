package com.example.server.drug.controller;

import com.example.server.drug.entity.UnitOfMeasure;
import com.example.server.drug.repository.UnitOfMeasureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UnitOfMeasureController {

    @Autowired
    private final UnitOfMeasureRepository unitofmeasureRepository;

    public UnitOfMeasureController(UnitOfMeasureRepository unitofmeasureRepository) {
        this.unitofmeasureRepository = unitofmeasureRepository;
    }
    @GetMapping("/unitm")
    public Collection<UnitOfMeasure> UnitOfMeasures() {
        return unitofmeasureRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/unitm/{id}")
    public Optional<UnitOfMeasure> UnitOfMeasures(@PathVariable Long id) {
        Optional<UnitOfMeasure> unitofmeasure = unitofmeasureRepository.findById(id);
        return unitofmeasure;
    }
}
