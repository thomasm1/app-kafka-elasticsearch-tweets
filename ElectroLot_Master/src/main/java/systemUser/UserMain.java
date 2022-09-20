package systemUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.ScannerCalculator;

import logger.LogGround;
import models.Car;
import models.Groot;
import models.User;  
import service.CarService;
import service.DataService;
import util.HashtableChain; 
import util.HashtableProbe;
import util.Tree;

public class UserMain {

    // main class here
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		LogGround.logger();
		System.out.println("|||___________________||| \n #0 log ...Logging by Log4j2.\n");/// #0 log

		/// #0 Validate and Load local User State
		frontConsoleValidation();
		
		/// #1 check for Oracle JDBC Driver 
		try {
			System.out.println("#1 Success! driver: " +Class.forName("oracle.jdbc.driver.OracleDriver"));
			System.out.println("1 ..found Oracle JDBC Driver...ready to connect.");
		} catch (ClassNotFoundException e) {
			System.out.println("oops, Driver not found :-O. Hey! Check Build Path for the Oracle Java Database Connector Class! Physically put the jar into ");
		}
		/// #2 Loading frontConsole Menu
		try { 
			System.out.println("#2 Loading frontConsole menu");
			frontConsoleMenu(); // 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("oops, #2 menu fail");
//			UserMain.main(args);
			System.exit(0);
		}
		/// #3 Loading Scanner accepting Integer Input
				try {
					frontConsole();
					System.out.println(" #3 Loading Scanner accepting Integer Input");
				} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("oops!! #3 scanner fail");
				}
	}
	 
 
	public static void carlotView() {
		List<Car> carList = CarService.getAllCarsCust(); // Customer view of carlot.
		System.out.println("\nWelcome  !\n  " + ">>>> Now featuring 2020 e-Cars!! <<<<");

		System.out.println(carList);
		frontConsole();
	}
	 protected static File checkLocalfiles(String path)  throws FileNotFoundException {
		  	// if no path provided, local here: 
		 //TODO UPDATE using JavaScript Dynamically get browser & OS, etc.
		 // Assuming I pass a null (usually), this method returns default
			String fileFullPath = (path!=null) ?  path : "C://w/www/java-devops/project0/src/main/java/systemUser/scannertext.txt";
			File textFile = new File(fileFullPath );
			return textFile;
		}
		
	
	/*
	 * frontConsole() method soon to be moved into a Singleton Session ..
	 * Class.forName("oracle.jdbc.driver.OracleDriver, but now auto-bounnd npi with database of user.
	 */
	public static void frontConsoleValidation() throws IOException, ClassNotFoundException {
 
			// ## Checking data types and local input
			File file = checkLocalfiles(null);
			
			Scanner scanText = new Scanner(file);
			int rowInt1 = scanText.nextInt(); 
			System.out.println("\n    #=====document ID: "+ rowInt1+"========#");
			String rowString1 = scanText.next(); 
			System.out.println("    Welcome  " + rowString1 + " .., I am now updated with your database: "+ Class.forName("oracle.jdbc.driver.OracleDriver")+ " ...\nWhat can I do next?");
			System.out.println("    #=============#");
			long rowLong1 = scanText.nextLong();
			rowLong1 = System.currentTimeMillis();
			System.out.println("\n#===Maven Dashboard Validation. " + rowLong1 + " o'clock!"+startupTime());
			scanText.close(); 
	}
	
	public static void frontConsoleMenu() {
		System.out.println(
				"\n1.) Log in press '1'.\n" + "2.) Register (get great deals and make offers), press '2'"
						+ "\n3.) Browse the lot,  press '3'." + 
						"\n4.) Data Structures Manipulation,  press '4'." + 
						"\n\nExit, press '0'.");
	}
	
	public static void frontConsole() {
		frontConsoleMenu();
		try {
			Scanner newScan = new Scanner(System.in);
			boolean hasNextInt = newScan.hasNextInt();
			int val = newScan.nextInt();
			try {
				/// Validate 
				if (val < 0 | val > 4 | !hasNextInt) {
					System.out.println("Please enter valid choices: 0-3");
					UserMain.frontConsole();
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
						frontConsole();
					}
					}
					newScan.close();
				}
				
				
			} catch (SQLException e) {
				System.out.println("Input digits from 0 - 4" + e);
				frontConsole();
			}
			frontConsole();

			
		} catch (InputMismatchException e) {
			System.out.println("Oops, Inputs! must choose 1,2,3,4... " + e);
			frontConsole();
		}
	}
	
	
	private static String startupTime() {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
//		System.out.println(formatter.format(date));
		return formatter.format(date);
	}
}
