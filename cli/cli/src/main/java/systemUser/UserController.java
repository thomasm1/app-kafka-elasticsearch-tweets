
package systemUser;

import java.sql.SQLException;
import java.util.InputMismatchException; 
import java.util.List;
import java.util.Scanner; 
import service.ControllerService; 

import util.ScannerCalculator;

public class UserController {
	
	public static void userController () throws SQLException {
		welcomeConsul(System.getProperty("cKey"));
		System.out.println("*---------------------------------*");
		System.out.println(
				"\nWelcome to your talking JAR: \n " + " ... What's Next? \n " + ""
						+ "1.) View available  Data Structures tooling, including known methods, customized\n "
						+ "2.) View available  Algorithms \n "
						
						+ "3.) Add Algorithms\n Formulate and add formula: 1. inputs, 2. output, 3. data types, 4. tests"  
						+ "4.) Caculate. Run Algorithms. Want to Hash something? Make a Glossary on-the-fly? Let's go ==>4\n "
						
						+ "5.) View History of Run Jobs\n "
						+ "0.) Logout");
 
		try {
			Scanner scan = new Scanner(System.in);
			int val = scan.nextInt();
			// Validation
			if (val >= 0 && val <= 6) {
				switch (val) {
				case 1: {
					scan.nextLine();
					char[] structList = ControllerService.getAllStructs(); 
					System.out.println(structList);
					userController();
				}
				case 2: {
					char[] aList = ControllerService.getAllAlgorithms();
					System.out.println("Entering Algorithms View...");
					System.out.println(ControllerService.getAllAlgorithms().toString()); 
					System.out.println(
							"\nWhat is next, Valued One? \n... Shall I order you a pizza for a late lunch?... \n ");
					userController();
				}
				case 3: {
					scan.nextLine();
					System.out.println("Adding a car? Let me get my notepad ...");
					System.out.println("Car ID?");
					while (true) {
						try {
							scan.nextInt();
							scan.nextLine();
							System.out.println("entry name?");
							String entry = scan.nextLine();
							System.out.println("Data  : i.e., json, xml, csv?");
							String data = scan.nextLine();
							System.out.println("Algorithm Description");
							String desc = scan.nextLine(); 
				 
							System.out.println("Umkay \n" + entry + " will be delivered using type "+data);
							System.out.println("Umkay \n" + desc);
							System.out.println("    Everything look right? (y) or (no)\n");
							String y = scan.nextLine();
 
						} catch (Exception e) {
							System.out.println("Oops, something went wrong, try again please\n");
						} 
						userController();
					}
				}
				case 4: {
					scan.nextLine();
					System.out.println("Running a Program? Let me get my notepad ...");
					System.out.println("Enter your program number - ");
					while (true) {
						try { 
							
							System.out.println("program?");
							int programId = scan.nextInt();
//							
//							if(programId = 1) {
//								
//							DASHBOARD CONTROLLER ; BREAK;
							
							Scanner scalc = new Scanner(System.in);
									int a = scalc.nextInt();
								String op = scalc.next();
								int b = scalc.nextInt();
								if (op.equals("+")) {
									ScannerCalculator.plus(a,b);
								}
//							}
							System.out.println("entry name?");
							String entry = scan.nextLine();
							System.out.println("Data  : i.e., json, xml, csv?");
							String data = scan.nextLine();
							System.out.println("Algorithm Description");
							String desc = scan.nextLine(); 
				 
							System.out.println("Umkay \n" + entry + " will be delivered using type "+data);
							System.out.println("Umkay \n" + desc);
							System.out.println("    Everything look right? (y) or (no)\n");
							String y = scan.nextLine();
 
							scalc.close();
							
						} catch (Exception e) {
							System.out.println("Oops, something went wrong, try again please\n");
						} 
						userController();
					}
				}
				case 5: {
		 
					userController();
				}
				case 6: {
			 
					userController();
				}
				case 0: {
					System.out.println("At your service, logging you out now ...\n");
					System.exit(0);				}
				} // end switch
			} else {
				System.out.println("Please enter digits 0 to 6");
				userController();
			}
		} catch (InputMismatchException e) {
			// go round again. Read past the end of line in the input first
			System.out.println("Please enter digits 0 to 6");
			userController();
		}
	}
  
	  

	public static void welcomeConsul(String userName) throws SQLException {  

		System.out.println("\n  Switching to User Console! *" + userName + "*, ");

		userController();
	}
}
