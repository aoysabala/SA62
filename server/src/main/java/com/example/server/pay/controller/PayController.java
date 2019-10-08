package com.example.server.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import com.example.server.pay.entity.*;
import com.example.server.pay.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PayController {

    @Autowired
    private final PayRepository PayRepository;
    @Autowired
    private FinancialOfficerRepository financialofficerRepository;
    @Autowired
    private PayTypeRepository PaytypeRepository;
    @Autowired
    private TreatmentRightsRepository treatmentrightsRepository;

    PayController(PayRepository PayRepository) {
        this.PayRepository = PayRepository;
    }
    @GetMapping("/Pay")
    public Collection<Pay> Pay() {
        return PayRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/Pay/{nameid}/{Finanid}/{paytypeid}/{treatmentid}")
    public Pay newPay(@PathVariable Double totle,
                      @PathVariable String namepay,
                      @PathVariable Date date,
                      @PathVariable long finanId,
                      @PathVariable long paytypeId,
                      @PathVariable long treatmentId) {

        Pay pay = new Pay();
        pay.setTotleprice(totle);
        pay.setNamepay(namepay);
        pay.setPaydate(date);

        PayType paytypes = PaytypeRepository.findById(paytypeId);
        pay.setPaytype(paytypes);
        FinancialOfficer financialofficers = financialofficerRepository.findById(finanId);
        pay.setFinancialOfficer(financialofficers);
        TreatmentRights treatmentrightss = treatmentrightsRepository.findById(treatmentId);
        pay.setTreatmentrights(treatmentrightss);

        return PayRepository.save(pay);
    }
}