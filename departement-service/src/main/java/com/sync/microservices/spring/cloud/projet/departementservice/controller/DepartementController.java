package com.sync.microservices.spring.cloud.projet.departementservice.controller;

import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;
import com.sync.microservices.spring.cloud.projet.departementservice.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping("{id}")
    ResponseEntity<DepartementDto> recupererDepartementParId(@PathVariable("id") Integer id) {
        DepartementDto departementDto = departementService.recupererDepartement(id);
        return ResponseEntity.ok(departementDto);
    }

    @GetMapping("code/{code}")
    ResponseEntity<DepartementDto> recupererDepartementParCode(@PathVariable("code") String code) {
        DepartementDto departementDto = departementService.recupererDepartementParCode(code);
        return ResponseEntity.ok(departementDto);
    }

    @PostMapping
    ResponseEntity<DepartementDto> enregitrerDepartement(@RequestBody DepartementDto departementDto) {
        DepartementDto departementEnregistreDto = departementService.enregistrerDepartement(departementDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(departementEnregistreDto);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> supprimerDepartement(@PathVariable("id") Integer id) {
        departementService.supprimerDepartement(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
