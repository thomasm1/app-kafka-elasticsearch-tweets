package xyz.cryptomaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

//@SpringBootApplication
//@EnableIntegration
public class ClientMaplIntegrationApplication2 {

	public static void main(String[] args)  throws Exception {
		SpringApplication.run(ClientMaplIntegrationApplication2.class, args);
		Thread.currentThread().join();
	}

}
