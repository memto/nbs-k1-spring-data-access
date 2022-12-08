package com.nbstech.spring.basic.dataaccess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication // @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
//@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.*")
public class SpringbootDataAccessApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataAccessApplication.class, args);
	}
}
