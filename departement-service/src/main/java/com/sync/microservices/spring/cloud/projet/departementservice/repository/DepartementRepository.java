package com.sync.microservices.spring.cloud.projet.departementservice.repository;

import com.sync.microservices.spring.cloud.projet.departementservice.entity.DepartementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<DepartementEntity, Integer> {

    DepartementEntity getByCode(String code);

}
