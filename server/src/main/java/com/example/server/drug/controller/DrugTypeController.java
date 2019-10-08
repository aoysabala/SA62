package com.example.server.drug.controller;

import com.example.server.drug.entity.DrugType;
import com.example.server.drug.repository.DrugTypeRepository;

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
public class DrugTypeController {

    @Autowired
    private final DrugTypeRepository drugtypeRepository;

    public DrugTypeController(DrugTypeRepository drugtypeRepository) {
        this.drugtypeRepository = drugtypeRepository;
    }
    @GetMapping("/type")
    public Collection<DrugType> DrugTypes() {
        return drugtypeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/type/{id}")
    public Optional<DrugType> DrugTypes(@PathVariable Long id) {
        Optional<DrugType> drugtype = drugtypeRepository.findById(id);
        return drugtype;
    }
}
