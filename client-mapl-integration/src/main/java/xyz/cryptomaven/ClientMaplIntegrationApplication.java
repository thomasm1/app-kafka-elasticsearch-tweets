package xyz.cryptomaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;


//@IntegrationComponentScan
@SpringBootApplication
public class ClientMaplIntegrationApplication {

	public static void main(String[] args)  throws Exception {
		SpringApplication.run(ClientMaplIntegrationApplication.class, args);
		Thread.currentThread().join();
	}


}
