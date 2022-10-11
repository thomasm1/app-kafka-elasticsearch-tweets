package xyz.cryptomaven.app.cli;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		//server
//		SpringApplication.run(CliApplication.class, args);

		// Data Loader
		cliDataLoader();
		// Navigation
		CliNavigator.mainNavigator(new String[] {"no", "options","now"});
		
		// Automated USER
		startBookmarking();
		buyCar();

		// USER MAIN
		cliUser();

	}



}
