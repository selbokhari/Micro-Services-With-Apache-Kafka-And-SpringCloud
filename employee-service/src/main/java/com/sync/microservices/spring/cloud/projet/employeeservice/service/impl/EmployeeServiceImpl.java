package com.sync.microservices.spring.cloud.projet.employeeservice.service.impl;

import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;
import com.sync.microservices.spring.cloud.projet.employeeservice.dto.EmployeeDto;
import com.sync.microservices.spring.cloud.projet.employeeservice.entity.EmployeeEntity;
import com.sync.microservices.spring.cloud.projet.employeeservice.kafka.KafkaDepartementProducer;
import com.sync.microservices.spring.cloud.projet.employeeservice.mapper.EmployeeMapper;
import com.sync.microservices.spring.cloud.projet.employeeservice.repository.EmpolyeeRepository;
import com.sync.microservices.spring.cloud.projet.employeeservice.service.DepartementClient;
import com.sync.microservices.spring.cloud.projet.employeeservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {



    private EmpolyeeRepository empolyeeRepository;

    private EmployeeMapper employeeMapper;

    private DepartementClient departementClient;

    private KafkaDepartementProducer kafkaDepartementProducer;

    // Méthode à appler pour effectuer un traitement si le Departement-MS est indisponible
    public EmployeeDto recupererDepartementParDefaut(Integer id, Exception exception) {
        log.error("Call Back de recuperation de departement ");
        EmployeeEntity employeeEntity = empolyeeRepository.getReferenceById(id);
        EmployeeDto employeeDto = employeeMapper.mapToEmployeeDtoWithIgniorDepartementCode(employeeEntity);
        log.error("Echec de récupération de département dont le code : {} ",employeeEntity.getCodeDepartement());
        employeeDto.setDepartement(null);
        return employeeDto;
    }

    // @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "recupererDepartementParDefaut")
    @Retry(name = "${spring.application.name}", fallbackMethod = "recupererDepartementParDefaut")
    @Override
    public EmployeeDto recupererEmployee(Integer id) {
        log.info("Recuperation des infos d'employee id {} ", id );
        EmployeeEntity employeeEntity = empolyeeRepository.getReferenceById(id);
        EmployeeDto employeeDto = employeeMapper.mapToEmployeeDtoWithIgniorDepartementCode(employeeEntity);
        ResponseEntity<DepartementDto> departementDto = departementClient.recupererDepartementParCode(employeeEntity.getCodeDepartement());
        employeeDto.setDepartement(departementDto.getBody());
        return employeeDto;
    }

    @Override
    public EmployeeDto creerEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeMapper.mapToEmployeeEntity(employeeDto);
        EmployeeEntity employeeEntityEnregistre = empolyeeRepository.save(employeeEntity);
        return employeeMapper.mapToEmployeeDto(employeeEntityEnregistre);
    }

    @Override
    public void supprimerEmployee(Integer id) {
        empolyeeRepository.deleteById(id);
    }


    @Override
    public EmployeeDto creerEmployeeAvecDepartement(EmployeeDto employeeDto) {
        log.info("Création d'employee avec département ");
        kafkaDepartementProducer.creerDepartement(employeeDto.getDepartement());
        return creerEmployee(employeeDto);
    }

}
