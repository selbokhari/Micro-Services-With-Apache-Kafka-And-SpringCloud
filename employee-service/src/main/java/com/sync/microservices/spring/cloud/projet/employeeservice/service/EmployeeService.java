package com.sync.microservices.spring.cloud.projet.employeeservice.service;

import com.sync.microservices.spring.cloud.projet.employeeservice.dto.EmployeeDto;

public interface EmployeeService {


    // ResponseEntity<DepartementDto> recupererDepartementParCode(String code);

    EmployeeDto recupererEmployee(Integer id);

    EmployeeDto creerEmployee(EmployeeDto employeeDto);

    void supprimerEmployee(Integer id);

    EmployeeDto creerEmployeeAvecDepartement(EmployeeDto employeeDto);

}
