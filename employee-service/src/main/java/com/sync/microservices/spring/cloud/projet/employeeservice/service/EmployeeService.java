package com.sync.microservices.spring.cloud.projet.employeeservice.service;

import com.sync.microservices.spring.cloud.projet.employeeservice.dto.DepartementDto;
import com.sync.microservices.spring.cloud.projet.employeeservice.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {


    // ResponseEntity<DepartementDto> recupererDepartementParCode(String code);

    EmployeeDto recupererEmployee(Integer id);

    EmployeeDto creerEmployee(EmployeeDto employeeDto);

    void supprimerEmployee(Integer id);

    EmployeeDto creerEmployeeAvecDepartement(EmployeeDto employeeDto);

}
