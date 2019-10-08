package com.example.server.pharmacist.controller;

import com.example.server.pharmacist.entity.Position;
import com.example.server.pharmacist.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PositionController {

    @Autowired
    private final PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }
    @GetMapping("/position")
    public Collection<Position> Positions() {
        return positionRepository.findAll().stream().collect(Collectors.toList());
    }
}
