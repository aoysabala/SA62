package com.example.server.pay.repository;

import com.example.server.pay.entity.PayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:8080")
public interface PayTypeRepository extends JpaRepository <PayType, Long> {
    PayType findById(long paytypeId);
}