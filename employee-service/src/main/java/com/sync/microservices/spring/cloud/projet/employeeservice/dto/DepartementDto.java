package com.sync.microservices.spring.cloud.projet.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDto {

    private Integer id;

    private String nom;

    private String discription;

    private String code;

}
