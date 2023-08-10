package com.sync.microservices.spring.cloud.projet.departementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * INFO: @EnableEurekaClient annotation  supprimée depuis la version de Spring Boot
 */
@SpringBootApplication
public class DepartementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartementServiceApplication.class, args);
	}

}
