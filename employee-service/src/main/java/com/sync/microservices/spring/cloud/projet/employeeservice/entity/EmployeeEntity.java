package com.sync.microservices.spring.cloud.projet.employeeservice.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(nullable = false)
    private String prenom;

    @NotBlank
    @Column(nullable = false)
    private String nom;

    private String mail;

    private String telephone;

    private Date dateNaissance;

    @NotBlank(message = "Le code de département est oblogatoire")
    private String codeDepartement;

}
