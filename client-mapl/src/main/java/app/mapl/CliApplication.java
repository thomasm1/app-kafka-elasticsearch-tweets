package app.mapl;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import app.mapl.consoles.MainDashboard;
import app.mapl.logger.LogCustom;

@ServletComponentScan("app.mapl")
@EnableJpaRepositories("app.mapl.repositories")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@ComponentScan("app.mapl")
@EntityScan("app.mapl.models")
@SpringBootApplication
public class CliApplication {


	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		System.out.println("INSIDE ____________CliApplication.main()");
		ApplicationContext ctx = SpringApplication.run(CliApplication.class, args);

		for (String name : ctx.getBeanDefinitionNames()){
			System.out.println(name);
		}
		System.out.println("******* Bean Count *******");
		System.out.println(ctx.getBeanDefinitionCount());

		LogCustom.logger();


		// USER MAIN
		MainDashboard.mainConsole(args);
	}




}
