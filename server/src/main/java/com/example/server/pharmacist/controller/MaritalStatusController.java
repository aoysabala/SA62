package com.example.server.pharmacist.controller;

import com.example.server.pharmacist.entity.MaritalStatus;
import com.example.server.pharmacist.repository.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class MaritalStatusController {

    @Autowired
    private final MaritalStatusRepository maritalstatusRepository;

    public MaritalStatusController(MaritalStatusRepository maritalstatusRepository) {
        this.maritalstatusRepository = maritalstatusRepository;
    }
    @GetMapping("/maritalstatus")
    public Collection <MaritalStatus> MaritalStatuss() {
        return maritalstatusRepository.findAll().stream().collect(Collectors.toList());
    }
}
