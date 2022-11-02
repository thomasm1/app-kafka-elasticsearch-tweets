package xyz.cryptomaven.app.cli;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.cryptomaven.app.consoles.MainDashboard;

@SpringBootApplication
public class CliApplication {


	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//		SpringApplication.run(CliApplication.class, args);



		// USER MAIN
		MainDashboard.mainUser(args);
	}




}
