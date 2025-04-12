package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

//@Configuration
@EnableAutoConfiguration
// @ComponentScan(basePackages={"com.udemy.controller","com.udemy.component","com.udemy.configuration","com.udemy.service","com.udemy.converter"})
//@EntityScan("com.udemy.entity")
// @EnableJpaRepositories("com.udemy.repository")  //no realmente necesaria SINO hay repositorios

public class BackendninjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendninjaApplication.class, args);
	}

}
