package com.example.server.pharmacist.controller;

import com.example.server.pharmacist.entity.Religion;
import com.example.server.pharmacist.repository.ReligionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ReligionController {

    @Autowired
    private final ReligionRepository religionRepository;

    public ReligionController(ReligionRepository religionRepository) {
        this.religionRepository = religionRepository;
    }
    @GetMapping("/religion")
    public Collection<Religion> Religions() {
        return religionRepository.findAll().stream().collect(Collectors.toList());
    }
}
