package com.sync.microservices.spring.cloud.projet.departementservice.kafka;

import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;
import com.sync.microservices.spring.cloud.projet.departementservice.service.DepartementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Slf4j
@Service
public class KafkaDepartementConsumer {

    private DepartementService departementService;

    @KafkaListener(topics = "CREATION_DEPARTEMENT", groupId = "EMPLOYEE_SERVICE_CONSUMER_GROUPE")
    public void ecouterCreationDepartement(DepartementDto departementDto) {
        log.info("Creation de departement {} ", departementDto);
        DepartementDto departmentCree = departementService.enregistrerDepartement(departementDto);
        log.info("Departement créé id: {} ",departmentCree.getId());
    }

}
