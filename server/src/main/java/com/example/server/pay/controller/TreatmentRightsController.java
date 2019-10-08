package com.example.server.pay.controller;

import com.example.server.pay.entity.TreatmentRights;
import com.example.server.pay.repository.TreatmentRightsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TreatmentRightsController {

    @Autowired
    private final TreatmentRightsRepository treatmentrightsRepository;

    public TreatmentRightsController(TreatmentRightsRepository treatmentrightsRepository) {
        this.treatmentrightsRepository = treatmentrightsRepository;
    }
    @GetMapping("/treatment")
    public Collection<TreatmentRights> treatmentRightss() {
        return treatmentrightsRepository.findAll().stream().collect(Collectors.toList());
    }
}