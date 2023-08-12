package com.sync.microservices.spring.cloud.projet.employeeservice.service;

import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTEMENT-SERVICE")
public interface DepartementClient {

    // open feigh va créer un rest client pour le WS suivant.
    @GetMapping("departement/code/{code}")
    ResponseEntity<DepartementDto> recupererDepartementParCode(@PathVariable("code") String code);

}
