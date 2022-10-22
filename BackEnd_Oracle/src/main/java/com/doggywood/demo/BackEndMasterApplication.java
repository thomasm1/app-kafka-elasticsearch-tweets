package com.doggywood.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@EnableJpaRepositories("com.doggywood.repositories")
@ComponentScan("com.doggywood")
@EntityScan("com.doggywood.entities")
public class BackEndMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndMasterApplication.class, args);
		
	}

}
