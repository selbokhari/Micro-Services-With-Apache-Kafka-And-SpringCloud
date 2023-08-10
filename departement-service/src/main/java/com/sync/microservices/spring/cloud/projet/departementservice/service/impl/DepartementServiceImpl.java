package com.sync.microservices.spring.cloud.projet.departementservice.service.impl;

import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;
import com.sync.microservices.spring.cloud.projet.departementservice.entity.DepartementEntity;
import com.sync.microservices.spring.cloud.projet.departementservice.mapper.DepartementMapper;
import com.sync.microservices.spring.cloud.projet.departementservice.repository.DepartementRepository;
import com.sync.microservices.spring.cloud.projet.departementservice.service.DepartementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@AllArgsConstructor
@Service
public class DepartementServiceImpl implements DepartementService {


    DepartementRepository departementRepository;
    DepartementMapper departementMapper;

    @Override
    public DepartementDto enregistrerDepartement(DepartementDto departementDto) {
        DepartementEntity departementEntity = departementMapper.mapTodepartement(departementDto);
        DepartementEntity departementEntityEnregitre = departementRepository.save(departementEntity);
        return departementMapper.mapTodepartementDto(departementEntityEnregitre);
    }

    @Override
    public void supprimerDepartement(Integer id) {
        departementRepository.deleteById(id);
    }


    @Override
    public DepartementDto recupererDepartement(Integer id) {
        DepartementEntity departementEntity = departementRepository.getReferenceById(id);
        log.info("Recuperation de département id :  {} ", id );
        return departementMapper.mapTodepartementDto(departementEntity);
    }

    @Override
    public DepartementDto recupererDepartementParCode(String code) {
        DepartementEntity departementEntity = departementRepository.getByCode(code);
        log.info("Recuperation de département code:  {} ", code);
        return departementMapper.mapTodepartementDto(departementEntity);
    }

}
