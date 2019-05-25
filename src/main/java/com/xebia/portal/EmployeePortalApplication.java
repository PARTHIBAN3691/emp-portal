package com.xebia.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.xebia.portal.controller.EmployeeController;

@SpringBootApplication
public class EmployeePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePortalApplication.class, args);
	}

}
