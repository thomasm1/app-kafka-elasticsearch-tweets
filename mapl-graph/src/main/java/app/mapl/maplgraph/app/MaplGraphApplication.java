package app.mapl.maplgraph.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@ComponentScan({"app.mapl.maplgraph.controller", "app.mapl.maplgraph.service"})
@EntityScan("app.mapl.maplgraph.entity")
@EnableNeo4jRepositories("app.mapl.maplgraph.repository")
public class MaplGraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaplGraphApplication.class, args);
	}

}
