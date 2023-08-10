package com.sync.microservices.spring.cloud.projet.departementservice.service;

import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;

public interface DepartementService {

    DepartementDto recupererDepartement(Integer id);

    DepartementDto recupererDepartementParCode(String code);

    DepartementDto enregistrerDepartement(DepartementDto departement);

    void supprimerDepartement(Integer id);

}
