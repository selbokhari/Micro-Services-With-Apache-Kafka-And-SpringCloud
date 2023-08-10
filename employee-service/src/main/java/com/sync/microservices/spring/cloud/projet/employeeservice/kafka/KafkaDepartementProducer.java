package com.sync.microservices.spring.cloud.projet.employeeservice.kafka;

import com.sync.microservices.spring.cloud.projet.employeeservice.dto.DepartementDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class KafkaDepartementProducer {

    private KafkaTemplate<String, DepartementDto> kafkaDepratementTemplate;

    public void creerDepartement(DepartementDto departement) {

        log.error("Création de departement : ", departement);
        kafkaDepratementTemplate.send("CREATION_DEPARTEMENT", departement);
    }

}
