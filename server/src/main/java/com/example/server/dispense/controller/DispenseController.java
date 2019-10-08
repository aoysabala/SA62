package com.example.server.dispense.controller;

import com.example.server.dispense.entity.*;
import com.example.server.dispense.repository.*;
import com.example.server.prescription.entity.*;
import com.example.server.prescription.repository.*;
import com.example.server.pharmacist.entity.*;
import com.example.server.pharmacist.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DispenseController {

    @Autowired
    private final DispenseRepository dispenseRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    DispenseController(DispenseRepository dispenseRepository) {

        this.dispenseRepository = dispenseRepository;
    }

    @GetMapping("/dispense")
    public Collection<Dispense> Dispense() {
        return dispenseRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/dispense/{patientsid}/{pharmaid}/{prescriptionsid}/{dosing}/{date}")
    public Dispense newDispense(@PathVariable long patientsid,
                                @PathVariable long pharmaid,
                                @PathVariable long prescriptionsid,
                                @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                @PathVariable String dosing) {

        Pharmacist pharmacists = pharmacistRepository.findBypharmaid(pharmaid);
        Patient patients = patientRepository.findById(patientsid);
        Prescription prescriptions = prescriptionRepository.findById(prescriptionsid);
        System.out.println("Prescription" + prescriptions);
        Dispense newDispense = new Dispense();
        newDispense.setDosing(dosing);
        newDispense.setPaydate(date);
        newDispense.setPharmacist(pharmacists);
        newDispense.setNamed(patients.getPatient());
        newDispense.setPatient(patients);
        newDispense.setPrescription(prescriptions);

        return dispenseRepository.save(newDispense);
    }
}
