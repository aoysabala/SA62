package com.example.server.drug.repository;

import com.example.server.drug.entity.DrugType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:8080")
public interface DrugTypeRepository extends JpaRepository <DrugType, Long>{
    DrugType findById(long typeid);
}
