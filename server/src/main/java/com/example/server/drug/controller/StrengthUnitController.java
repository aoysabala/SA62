package com.example.server.drug.controller;

import com.example.server.drug.entity.StrengthUnit;
import com.example.server.drug.repository.StrengthUnitRepository;

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
public class StrengthUnitController {

    @Autowired
    private final StrengthUnitRepository strengthunitRepository;

    public StrengthUnitController(StrengthUnitRepository strengthunitRepository) {
        this.strengthunitRepository = strengthunitRepository;
    }
    @GetMapping("/units")
    public Collection<StrengthUnit> StrengthUnits() {
        return strengthunitRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/units/{id}")
    public Optional<StrengthUnit> StrengthUnits(@PathVariable Long id) {
        Optional<StrengthUnit> strengthunit = strengthunitRepository.findById(id);
        return strengthunit;
    }
}
