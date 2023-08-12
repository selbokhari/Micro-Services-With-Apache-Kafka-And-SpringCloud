package com.sync.microservices.spring.cloud.projet.employeeservice.controller;

import com.sync.microservices.spring.cloud.projet.employeeservice.dto.EmployeeDto;
import com.sync.microservices.spring.cloud.projet.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmpolyeeController {

    EmployeeService employeeService;

    @GetMapping("{id}")
    ResponseEntity<EmployeeDto> recupererEmloyee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.recupererEmployee(id));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<EmployeeDto> creerEmloyee(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.creerEmployee(employeeDto));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> supprimerEmloyee(@PathVariable("id") Integer id) {
        employeeService.supprimerEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *
    * Créer un Employee avec son departement.
    *
    * */
    @PostMapping(path ="avec-departement", consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<EmployeeDto> creerEmloyeeEtDepartement(@Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.creerEmployeeAvecDepartement(employeeDto));
    }

}
