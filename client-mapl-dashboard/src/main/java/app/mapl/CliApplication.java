package app.mapl;

import java.io.IOException;
import java.sql.SQLException;

import app.mapl.mail.MailConfig;
import app.mapl.models.MaplConfig;
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
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import app.mapl.util.config.logger.LoggerImpl;
import org.springframework.scheduling.annotation.EnableAsync;
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
@EnableJpaAuditing//(auditorAwareRef = "auditorAware")
@EnableAsync
@EntityScan("app.mapl.models")
@ConfigurationPropertiesScan("app.mapl.util.config.*")
@EnableConfigurationProperties(value={MaplConfig.class })
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, MailSenderAutoConfiguration.class
})
@ComponentScan( excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {MailConfig.class}))
public class CliApplication {



	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static RestTemplate restTemplate;
//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	public static final Logger log;

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
		log.info("******* Application Name *******");
		log.info(ctx.getApplicationName());
		LoggerImpl.loggerInstance(new String[] { "CliApplication.main()" });
//		for (String name : ctx.getBeanDefinitionNames()){
//			log.info(name);
//		}
	}

	public static void statusCode(ResponseEntity<String> responseEntity) {
		HttpStatusCode statusCode = responseEntity.getStatusCode();
		log.info("status code - " + statusCode);
		String user = responseEntity.getBody();
		log.info("response body - " + user);
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		System.out.println("response Headers - " + responseHeaders);
	}


}
