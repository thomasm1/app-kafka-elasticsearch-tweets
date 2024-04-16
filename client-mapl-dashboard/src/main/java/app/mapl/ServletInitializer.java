package app.mapl;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/*
 * This class configures the servlet context  needed to run the application as a WAR file in a servlet container.
 * ServletInitializer integrates Spring framework capabilities into servlet container,
 *  setting up the Spring context and linking it with the lifecycle of the servlet through the onStartup method.
 * (This is where to configure classes and initialize components before integrating into the servlet environment.)
 *  */

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CliApplication.class);
	}

}
