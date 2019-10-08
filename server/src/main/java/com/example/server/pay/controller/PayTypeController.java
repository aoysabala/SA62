package com.example.server.pay.controller;

import com.example.server.pay.entity.PayType;
import com.example.server.pay.repository.PayTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PayTypeController {

    @Autowired
    private final PayTypeRepository paytypeRepository;

    public PayTypeController(PayTypeRepository paytypeRepository) {
        this.paytypeRepository = paytypeRepository;
    }
    @GetMapping("/paytype")
    public Collection<PayType> paytypes() {
        return paytypeRepository.findAll().stream().collect(Collectors.toList());
    }
}