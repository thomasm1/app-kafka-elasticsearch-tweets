package app.mapl;

import static app.mapl.rest.mcp.TopicRunner.topicRunner;

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
@EnableJpaRepositories("app.mapl")
@EntityScan("app.mapl")
public class IntelligenceArtificielleApplication {
	private static final Logger log;

	static {
		log = LoggerFactory.getLogger(IntelligenceArtificielleApplication.class);
	}
	public static void main(String[] args)  throws Exception {
		ApplicationContext ctx = SpringApplication.run(IntelligenceArtificielleApplication.class, args);

		for (String name : ctx.getBeanDefinitionNames()){
//			log.info(name);
		}
		log.info("logbeans ____dev____XXXXXX");
		log.info("****log.info*** Bean Count *******");
		log.info(String.valueOf(ctx.getBeanDefinitionCount()));
		log.info("***log.info**** Class Loader *******");
		log.info(ctx.getClassLoader().toString());

		System.out.println("******* Application Name *******");
		log.info(ctx.getApplicationName());


  //MCP Topic Runner

   topicRunner(
       new String[]{
           "Paris, France,Exploring the latest in AI and technology,https://paris-ai.com/2023,250801"}
	 );
	}


}
