package app.mapl;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import app.mapl.consoles.MainDashboard;
import app.mapl.logger.LogCustom;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@EnableFeignClients
@ServletComponentScan("app.mapl")
@EnableJpaRepositories("app.mapl.repositories")
@EntityScan("app.mapl.models")
@SpringBootApplication
public class CliApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build();
	}

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
