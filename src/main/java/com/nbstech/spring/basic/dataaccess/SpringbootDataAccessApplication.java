package com.nbstech.spring.basic.dataaccess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.nbstech.spring.basic.dataaccess.restapi")
@EntityScan(basePackages = "com.nbstech.spring.basic.dataaccess.restapi")
@EnableJpaRepositories(basePackages = "com.nbstech.spring.basic.dataaccess.restapi")
public class SpringbootDataAccessApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataAccessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Application started");
	}
}
