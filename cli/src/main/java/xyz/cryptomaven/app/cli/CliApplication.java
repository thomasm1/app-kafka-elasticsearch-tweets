package xyz.cryptomaven.app.cli;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import system.MainDashboard;
import utilConcurrency.DownloadThreadTask;

import static xyz.cryptomaven.app.cli.CliLoader.cliDataLoader;
import static xyz.cryptomaven.app.cli.CliLoader.start;
import static xyz.cryptomaven.app.cli.CliLoader.buyCar;

@SpringBootApplication
public class CliApplication {

	private static void cliUser() {
		try {
			String[] args = { "first", "cli", "optional", "strings" };
			MainDashboard.mainUser(args);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("PROBLEM WITH UserMain.mainUser");
			e.printStackTrace();
		}
	}
	private static void runDownloaderJob() {
		DownloadThreadTask task = new DownloadThreadTask(true);
		(new Thread((Runnable) task)).start();
	}

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//		SpringApplication.run(CliApplication.class, args);

		// Data Loader
		cliDataLoader();
		// Automated USER
		start();  /// Test Data
		buyCar();

		// Background Loader
		runDownloaderJob();

		// USER MAIN
		cliUser(); // Pathway to CliNavigator
	}




}
