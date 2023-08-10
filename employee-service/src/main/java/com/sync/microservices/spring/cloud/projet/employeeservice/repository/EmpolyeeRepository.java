package com.sync.microservices.spring.cloud.projet.employeeservice.repository;

import com.sync.microservices.spring.cloud.projet.employeeservice.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpolyeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
