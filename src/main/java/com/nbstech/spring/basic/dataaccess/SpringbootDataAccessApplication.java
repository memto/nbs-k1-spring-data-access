package com.nbstech.spring.basic.dataaccess;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

//@SpringBootApplication // @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
//@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.*")
@EntityScan(basePackages = "com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.*")
@EnableJpaRepositories("com.nbstech.spring.basic.dataaccess.Relationships.OneToOne.*")
public class SpringbootDataAccessApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataAccessApplication.class, args);
	}

	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server h2Server() throws SQLException {
		return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
	}
}
