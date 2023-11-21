package com.doggywood.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaRepositories("com.doggywood.repositories")
@ComponentScan("com.doggywood")
@EntityScan("com.doggywood.entities")
//@EnableFeignClients
public class BackEndMasterApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	public static void main(String[] args) {
		SpringApplication.run(BackEndMasterApplication.class, args);

	}

}
