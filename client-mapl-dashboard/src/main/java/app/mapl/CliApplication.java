package app.mapl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import app.mapl.models.User;
import app.mapl.service.PostServiceJDBC;
import app.mapl.service.UsersServiceJDBC;
import app.mapl.webControllers.ForEntityMethod;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import app.mapl.consoles.MainDashboard;
import app.mapl.config.logger.LoggerImpl;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

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
/// @EnableFeignClient
@ServletComponentScan("app.mapl")
@EnableJpaRepositories("app.mapl.repositories")
@EnableJpaAuditing
@EntityScan("app.mapl.models")
@ConfigurationPropertiesScan("app.mapl.config.*")
@EnableConfigurationProperties
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, MailSenderAutoConfiguration.class
})
public class CliApplication {


	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static RestTemplate restTemplate;
//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	private static final Logger log;

	static {
		log = LoggerFactory.getLogger(CliApplication.class);
	}

	@Bean
	public LoggerImpl loggerImpl() {
		return new LoggerImpl();
	}
	static String basePath = "api/";
	static String baseUrl = "http://localhost:8080/" + basePath; // Target URL

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

	// @Bean
	// public ModelMapper modelMapper(){
	// 	return new ModelMapper();
	// }


		log.info("INSIDE ____log.info__dddd______CliApplication.main()");
		ApplicationContext ctx = SpringApplication.run(CliApplication.class, args);

		logBeans(ctx);

		MainDashboard.console(args);
	}

	@Profile(value={"!prod"})
	private static void logBeans(ApplicationContext ctx) {
		log.info("logbeans ____dev____XXXXXX");
		log.info("****log.info*** Bean Count *******");
		log.info(String.valueOf(ctx.getBeanDefinitionCount()));
		log.info("***log.info**** Class Loader *******");
		log.info(ctx.getClassLoader().toString());
		log.info("***log.info**** Environment *******");
//		log.info(ctx.getEnvironment());
		System.out.println("******* Application Name *******");
		log.info(ctx.getApplicationName());
		LoggerImpl.loggerInstance(new String[] { "CliApplication.main()" });
//		for (String name : ctx.getBeanDefinitionNames()){
//			log.info(name);
//		}
	}

	public static void statusCode(ResponseEntity<String> responseEntity) {
		HttpStatusCode statusCode = responseEntity.getStatusCode();
		System.out.println("status code - " + statusCode);
		String user = responseEntity.getBody();
		System.out.println("response body - " + user);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("response Headers - " + responseHeaders);
	}


}
