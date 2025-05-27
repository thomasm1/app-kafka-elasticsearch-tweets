package xyz.cryptomaven.vectordb;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@OpenAPIDefinition(
		info = @Info(
				title = "Personal Crypto Librarian REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Thomas",
						email = "thomas1.maestas@gmail.com",
						url = "https://thomasmaestas.net"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "mapl-app User Management Documentation",
				url = "https://thomasmaestas.net/docs/mapl-app"
		)
)
@SpringBootApplication
@EnableJpaRepositories("xyz.cryptomaven.vectordb.mapl")
@EntityScan("xyz.cryptomaven.vectordb.mapl")
public class VectordbApplication {

	public static void main(String[] args) {  SpringApplication.run(VectordbApplication.class, args);
 }
}

