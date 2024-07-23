package xyz.cryptomaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.annotation.IntegrationComponentScan;


//@IntegrationComponentScan
@SpringBootApplication
@EnableJpaRepositories("xyz.cryptomaven.client_mapl.*")
@EntityScan("xyz.cryptomaven.client_mapl.*")
public class ClientMaplIntegrationApplication {

	public static void main(String[] args)  throws Exception {
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppFileConfig.class);
//		context.registerShutdownHook();
		ApplicationContext ctx = SpringApplication.run(ClientMaplIntegrationApplication.class, args);

		for (String name : ctx.getBeanDefinitionNames()){
			System.out.println(name);
		}
		System.out.println("******* Bean Count *******");
		System.out.println(ctx.getBeanDefinitionCount());
	}


}
