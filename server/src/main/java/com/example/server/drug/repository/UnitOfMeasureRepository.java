package com.example.server.drug.repository;

import com.example.server.drug.entity.UnitOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:8080")
public interface UnitOfMeasureRepository extends JpaRepository <UnitOfMeasure, Long> {
    UnitOfMeasure findById(long unitmid);
}