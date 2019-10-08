package com.example.server.pharmacist.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Collection;
import java.util.stream.Collectors;

import com.example.server.pharmacist.entity.*;
import com.example.server.pharmacist.repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PharmacistController {

    @Autowired
    private final PharmacistRepository pharmacistRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private MaritalStatusRepository maritalstatusRepository;
    @Autowired
    private ReligionRepository religionRepository;

    PharmacistController(PharmacistRepository pharmacistRepository) {
        this.pharmacistRepository = pharmacistRepository;
    }
    @GetMapping("/pharmacist")
    public Collection<Pharmacist> pharmacists() {
        return pharmacistRepository.findAll().stream().collect(Collectors.toList()); }
    @PostMapping("/pharmacist/{namepharmacist}/{positionid/{pharmaid}/{genderid}/" +
            "{age}/{birthDate}/{address}/{tel}/{maritid}/{religionid}")
    public Pharmacist newPharmadata(Pharmacist newPharmadata,
                                    @PathVariable String namepharmacist,
                                    @PathVariable long positionid,
                                    @PathVariable long pharmaid,
                                    @PathVariable long genderid,
                                    @PathVariable Integer age,
                                    @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate,
                                    @PathVariable String address,
                                    @PathVariable String tel,
                                    @PathVariable long maritid,
                                    @PathVariable long religionid) {

        Position position = positionRepository.findBypositionid(positionid);
        Gender gender = genderRepository.findBygenderid(genderid);
        MaritalStatus maritalstatus = maritalstatusRepository.findBymaritid(maritid);
        Religion religion = religionRepository.findByreligionid(religionid);

        newPharmadata.setPosition(position);
        newPharmadata.setGender(gender);
        newPharmadata.setMaritalstatus(maritalstatus);
        newPharmadata.setReligion(religion);

        return pharmacistRepository.save(newPharmadata);
    }
}

