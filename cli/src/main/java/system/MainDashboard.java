package system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.InputMismatchException;
import java.util.List; 
import java.util.Scanner;

import constants.Cmds;
import logger.LogCustom; 
import models.Car; 
import service.CarService;
import systemUser.UserLogin;
import systemUser.UserRegister;
import xyz.cryptomaven.app.cli.CliNavigator;

public class MainDashboard {
 
	public static void mainUser(String[] args) throws SQLException, ClassNotFoundException, IOException {

		LogCustom.logger();
		System.out.println("|||_________NEWTECH__________||| \n #0 log ...Logging by Log4j2.\n");/// #0 log

		/// #0 Validate and Load local User State
		/// #1 check for Oracle JDBC Driver
		frontConsoleValidation();

		/// #2  Loading Scanner accepting Integer Input
		try {
			console();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("oops!! #3 scanner fail");
		}
	}

	public static void carlotView() {
		List<Car> carList = CarService.getAllCarsCust(); // Customer view of carlot. 
		System.out.println(carList);

	}

	protected static File checkLocalfiles(String path) throws FileNotFoundException { 
		String fileFullPath = (path != null) ? path : String.valueOf("src/data/scannertext.txt");
		File textFile = new File(fileFullPath);
		return textFile;
	}

	public static void frontConsoleValidation() throws IOException, ClassNotFoundException {
		try {
			System.out.println("1 ..Success Oracle JDBC Driver"+Class.forName("oracle.jdbc.driver.OracleDriver") +" \n");
		} catch (ClassNotFoundException e) {
			System.out.println(	Cmds.OOPS_JDBC );
		}
		// ## Checking  local input
			File file =  checkLocalfiles(null);
		Scanner scanText = new Scanner(file);
		int rowInt1 = scanText.nextInt();
		System.out.println("\n    #=====Reading  \"src/scannertext.txt\" ID: " + rowInt1 + "========#\n");
		scanText.close();
	}

	public static void frontConsoleMenu() {
		System.out.println("\n1.) Log in press '1'.\n" + "2.) Register (get great deals and make offers), press '2'"
				+ "\n3.) Browse the lot,  press '3'." + "\n4.) Data Structures Manipulation,  press '4'."
				+ "\n\nExit, press '0'.");
	}
	public static void console() {
		System.out.println("Now Loading frontConsoleMenu()");
		frontConsoleMenu();
		try {
			Scanner newScan = new Scanner(System.in);
			boolean hasNextInt = newScan.hasNextInt();
			int val = newScan.nextInt();
			try { 
				if (val < 0 | val > 4 | !hasNextInt) {
					System.out.println("Please enter valid choices: 0-3");
	// RECURSE
					console();
				} else {
					switch (val) {
					case 1: {
						UserLogin.login();
						carlotView();
						break;
					}
					case 2: {
						UserRegister.register();
						carlotView();
						break;
					}
					case 3: {
						System.out.println("\n Ok, please enjoy your browsing....");
						carlotView();
						break;
					}
					case 4: {
						System.out.println("\n Ok, #4 ...");
						break;
					}
					case 0: {
						System.out.println("\n   Come Back *Soon* !\n");
						System.out.println("\n =======================!\n");
						CliNavigator.mainNavigator( new String[] {}); //{"any", "options"});
						break;
					}
					}
					console();
 // After returning & Break, back to console
				}

			} catch (SQLException e) {
				System.out.println("SQLException" + e);
				console();
 // RECURSE
			} catch (IOException e) {
				console();
 // RECURSE
			} catch (ClassNotFoundException e) {
				System.out.println("Oops, ClassNotFoundException " + e);
				console();
 // RECURSE
			}
			console();

		} catch (InputMismatchException e) {
			System.out.println("Oops, Inputs! must choose 1,2,3,4... " + e);
			console();
 // RECURSE
		}
	}

	private static String startupTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
//		System.out.println(formatter.format(date));
		return formatter.format(date);
	}
}