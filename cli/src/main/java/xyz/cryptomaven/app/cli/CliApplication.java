package xyz.cryptomaven.app.cli;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import systemUser.UserMain;

import static xyz.cryptomaven.app.cli.CliLoader.*;

@SpringBootApplication
public class CliApplication {

	private static void cliUser() {
		try {
			String[] args = { "first", "cli", "optional", "strings" };
			UserMain.mainUser(args);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("PROBLEM WITH UserMain.mainUser");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//server
//		SpringApplication.run(CliApplication.class, args);

		// Data Loader
		cliDataLoader();

		// Automated USER
		startBookmarking();
		buyCar();

		// USER MAIN
		cliUser(); 

	}


}
