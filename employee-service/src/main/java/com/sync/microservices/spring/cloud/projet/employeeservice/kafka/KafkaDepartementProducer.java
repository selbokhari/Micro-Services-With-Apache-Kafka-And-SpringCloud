package com.sync.microservices.spring.cloud.projet.employeeservice.kafka;

import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@RefreshScope
@Slf4j
@Service
public class KafkaDepartementProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaDepratementTemplate;

    @Value("${nom.departement.topic}")
    private String creationDepartementTopic;

    public void creerDepartement(DepartementDto departement) {

        log.info("Création de departement : {}", departement);
        Message<DepartementDto> departementDtoMessage = MessageBuilder
                .withPayload(departement)
                        .setHeader(KafkaHeaders.TOPIC, creationDepartementTopic)
                                .build();
        kafkaDepratementTemplate.send(departementDtoMessage);
    }

}
