package com.example.server.pay.controller;

import com.example.server.pay.entity.FinancialOfficer;
import com.example.server.pay.repository.FinancialOfficerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class FinancialOfficerController {

    @Autowired
    private final FinancialOfficerRepository financialofficerRepository;

    public FinancialOfficerController(FinancialOfficerRepository financialofficerRepository) {
        this.financialofficerRepository = financialofficerRepository;
    }
    @GetMapping("/financialofficer")
    public Collection<FinancialOfficer> FinancialOfficers() {
        return financialofficerRepository.findAll().stream().collect(Collectors.toList());
    }
}