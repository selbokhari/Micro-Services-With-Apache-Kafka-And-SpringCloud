package com.sync.microservices.spring.cloud.projet.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * INFO: @EnableEurekaClient annotation  supprimée depuis la version de Spring Boot 3 et Spring Cloud version 2022.0.X
 */
@EnableFeignClients(basePackages = "com.sync.microservices.spring.cloud.projet.employeeservice.service")
@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
