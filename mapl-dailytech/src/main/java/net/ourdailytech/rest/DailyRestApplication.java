package net.ourdailytech.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@EnableConfigurationProperties
@SpringBootApplication
public class DailyRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(DailyRestApplication.class, args);

	}


}
