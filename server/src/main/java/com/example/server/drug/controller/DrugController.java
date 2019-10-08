package com.example.server.drug.controller;

import com.example.server.drug.entity.*;
import com.example.server.drug.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DrugController {

    @Autowired
    private final DrugRepository drugRepository;
    @Autowired
    private DrugTypeRepository drugtypeRepository;
    @Autowired
    private StrengthUnitRepository strengthunitRepository;
    @Autowired
    private UnitOfMeasureRepository unitofmeasureRepository;

    DrugController(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }
    @GetMapping("/drug")
    public Collection<Drug> Drugs() {
        return drugRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping("/drug/{drugsid}/{named}/{nameg}/{typeid}/{streanth}/{unitsid}/{unitmid}")
    public Drug newDrug(@PathVariable String drugsid,
                        @PathVariable String named,
                        @PathVariable String nameg,
                        @PathVariable long typeid,
                        @PathVariable Double streanth,
                        @PathVariable long unitsid,
                        @PathVariable long unitmid) {

        Drug drug = new Drug();
        drug.setDrugsid(drugsid);
        drug.setNamed(named);
        drug.setNameg(nameg);
        drug.setStreangth(streanth);

        DrugType drugtypes = drugtypeRepository.findById(typeid);
        drug.setDrugtype(drugtypes);

        StrengthUnit strengthunits = strengthunitRepository.findById(unitsid);
        drug.setStrengthunit(strengthunits);

        UnitOfMeasure unitofmeasures = unitofmeasureRepository.findById(unitmid);
        drug.setUnitofmeasure(unitofmeasures);

        return drugRepository.save(drug);
    }
}
