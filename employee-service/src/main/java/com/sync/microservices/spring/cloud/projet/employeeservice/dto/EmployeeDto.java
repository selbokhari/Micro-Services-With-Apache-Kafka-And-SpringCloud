package com.sync.microservices.spring.cloud.projet.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sync.microservices.spring.cloud.projet.departementservice.dto.DepartementDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Getter
@Setter
public class EmployeeDto {

    private Integer id;

    @NotBlank(message = "Le nom est obligatoire")
    private String prenom;

    @NotBlank(message = "Le prenom est obligatoire")
    private String nom;

    @Email(message = "L'email saisi est invalide")
    @NotBlank(message = "L'email ne doit pas etre vide")
    private String mail;

    private String telephone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateNaissance;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotBlank(message = "codeDepartement ne doit pas etre vide")
    private String codeDepartement;

    private DepartementDto departement;

}
