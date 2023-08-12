package com.sync.microservices.spring.cloud.projet.departementservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DepartementDto {

    private Integer id;

    private String nom;

    private String discription;

    private String code;

}
