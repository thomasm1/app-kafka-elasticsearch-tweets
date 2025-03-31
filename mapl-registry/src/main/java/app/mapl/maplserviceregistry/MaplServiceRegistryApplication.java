package app.mapl.maplserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MaplServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaplServiceRegistryApplication.class, args);
	}

}
