package xyz.cryptomaven.app.cli;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import xyz.cryptomaven.app.consoles.MainDashboard;
import xyz.cryptomaven.app.logger.LogCustom;
import xyz.cryptomaven.app.repositories.UsersRepository;

@EnableJpaRepositories("xyz.cryptomaven.app.repositories")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@ComponentScan("xyz.cryptomaven.app")
@EntityScan("xyz.cryptomaven.app.models")
@SpringBootApplication
public class CliApplication {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
		SpringApplication.run(CliApplication.class, args);
		LogCustom.logger();


		// USER MAIN
		MainDashboard.mainUser(args);
	}




}
