package app.mapl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//@EnableEurekaClient
@EnableConfigServer
@SpringBootApplication
public class MaplConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaplConfigServerApplication.class, args);
	}

}
