
package systemUser;

import java.sql.SQLException;
import java.util.InputMismatchException;
//import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Car;
import models.ElectroLot;
import models.Offer;
//import systemAdmin.AdminLotState;
//import systemCars.CarsMain;
//import systemCars.OffersMain;
import service.CarService;
import service.ElectroLotService;
import service.OfferService;

public class AdminDashboard {

	public static void dashboardChoice() throws SQLException {

		System.out.println("*---------------------------------*");
		System.out.println(
				"\nWelcome to the dashboard\n " + " ... What's Next? \n " + "1.) View Financials and Payments\n "
						+ "2.) View Car Lot\n " + "3.) Add Car\n " // +"4.) Update as Purchased (also removes)\n "
						+ "4.) Remove Unpurchased Car\n " + "5.) View and/or Accept Offers\n " + "0.) Logout");
//OK* As an employee, I can add a car to the lot.
//OK * As an employee, I can accept or reject an offer for a car.
//OK* As an employee, I can remove a car from the lot.
//OK* As an employee, I can view all payments.  
		try {
			Scanner scan = new Scanner(System.in);
			int val = scan.nextInt();
			if (val >= 0 && val <= 5) {
				switch (val) {
				case 1: {
					scan.nextLine();
//					List<ElectroLot> electroList = ElectroLotService.getAllElectroLot();
					System.out.println(ElectroLotService.getAllElectroLot());
//					System.out.println(electroList);
					dashboardChoice();
				}
				case 2: {
//					List<Car> carList = CarService.getAllCars();
					System.out.println("Entering CarLot View...");
//					System.out.println(carList);
					System.out.println(CarService.getAllCars());
					System.out.println(
							"\nWhat is next, Valued Employee? \n... Shall I order you a pizza for a late lunch?... \n ");
					dashboardChoice();
				}
				case 3: {
					scan.nextLine();
					System.out.println("Adding a car? Let me get my notepad ...");
					System.out.println("Car ID?");
					while (true) {
						try {
							scan.nextInt();
							scan.nextLine();
							System.out.println("Car Make?");
							String make = scan.nextLine();
							System.out.println("Car Model?");
							String model = scan.nextLine();
							System.out.println("Car Price?");
							double price = scan.nextDouble();
							scan.nextLine();
							if (price > 999999.99) {
								System.out.println("price must be less than $1 million, please.");
								System.out.println("Car Price?");
								price = scan.nextDouble();
								scan.nextLine();
							} 
							System.out.println("Umkay,car's make is *" + make + "*,\n model is *" + model
									+ "*,\n and price at *$" + price + "*\n");
							System.out.println("   Everything look right? (y) or (no)\n");
							while (true) {
								String decide = scan.next();
								if (decide.contentEquals("y")) {
									Car createdCar = new Car(777, make, model, price, 0);
									CarService.createCar(createdCar);
									System.out.println(
											"This " + createdCar.getCarModel() + " has been Successfully added!!\n");
									dashboardChoice();
								} else {
									dashboardChoice();
								}
							} 
						} catch (Exception e) {
							System.out.println("Oops, something went wrong, try again please\n");
						} 
						dashboardChoice();
					}
				}
				case 4: {
					scan.nextLine();
					System.out.println("Removing a car? \nLet me get my notepad ...");
					System.out.println("\nCar ID to be removed?");
					while (true) {
						try {
							val = scan.nextInt();
							Car uCar = CarService.getCar(val);
							scan.nextLine();
							System.out.println("1.) Remove car #" + uCar.getCarID() + "? Type \"y\" or \"yes\"."
									+ "\n\n2.)To permanently delete from records?\n" + "If so, type \"delete\" \n");

							String decide = scan.next();
							if ((decide.contentEquals("y")) | (decide.contentEquals("yes"))) {
								Car removeCar = new Car(uCar.getCarID(), uCar.getCarMake(), uCar.getCarModel(),
										uCar.getPriceTotal(), 2); // 2 = remove unpurchased
								try {
									CarService.updateCar(removeCar);
									System.out.println(removeCar.toString() + "\n" + " ...\n..#" + uCar.getCarID()
											+ " Successfully removed!!\n");

								} catch (Exception e) {
									System.out.println("Oops, something went wrong, try again please\n");
								}
							} else if (decide.contentEquals("delete")) {// delete & unpurchased
								try {
									int deleted = uCar.getCarID();
									CarService.deleteCar(deleted);
									System.out.println("\n" + "\n...#" + deleted + " Permanently deleted!\n");

								} catch (Exception e) {
									System.out.println("Oops, something went wrong, try again please\n");
								}
							} else {
								System.out.println("Not implemented, returning to dashboard");
								dashboardChoice();
							}
						} catch (Exception e) {
							System.out.println("I could not find that car ...");
							System.out.println("Try again. Here's the current lot:");
							List<Car> carList = CarService.getAllCars();
							System.out.println(carList);
							dashboardChoice();
						}
						dashboardChoice();
					}
				}
				case 5: {
					List<Offer> offerList = OfferService.getAllOffers();
					System.out.println("Listing reports ...");
					System.out.println(offerList); 
					checkOffer(); // method below

					dashboardChoice();
				}
				case 0: {
					System.out.println("At your service, logging you out now ...\n");
					System.exit(0);
				}
				} // end switch
			} else {
				System.out.println("Please enter digits 0 to 5");
				dashboardChoice();
			}
		} catch (InputMismatchException e) {
			// go round again. Read past the end of line in the input first
			System.out.println("Please enter digits 0 to 5");
			dashboardChoice();
		}
	}

	private static void checkOffer() throws SQLException {

		Scanner scan = new Scanner(System.in);

		System.out.println("\n>>>Please type offer ID to view or modify. 0 to exit.");
		int oInt = scan.nextInt();  
		scan.nextLine();
		if (oInt == 0) {
			dashboardChoice();
		}
		Offer offerLook = OfferService.getOffer(oInt); 
		System.out.println(">>>Great, looking up offer #" + oInt + "....\n"); 
		if (offerLook == null) {
			System.out.println(">>>Oops, couldn't find it, " + "maybe double check the #id?\n");
			checkOffer();
		} else {
			System.out.println(offerLook);
			approveOrReject(offerLook); // nested method
		}
		dashboardChoice();
	}

	private static void approveOrReject(Offer offerLook) {
		try {
			System.out.println("\n>>>Accept this offer (y)?\n" + "or (r) to reject an offer\n"
					+ "\nOtherwise hit any key+'enter' to return to dashboard");
			Scanner scan = new Scanner(System.in);
			String decide = scan.nextLine();
			if (!decide.contentEquals("y") && !decide.contentEquals("r")) {
				dashboardChoice();
			} else if (decide.contentEquals("y")) {
				Offer offering = new Offer(offerLook.getOfferID(), offerLook.getUserName(), offerLook.getCarID(),
						offerLook.getOfferAmt(), offerLook.getOfferMos(), "APPROVED");
				// Finalize New-Owner's Offer details
				OfferService.updateOffer(offering); 
				// make New-Owner contract
				System.out.println(ElectroLot.makeElectro(offering));
				ElectroLotService.addElectroLot(ElectroLot.makeElectro(offering));
				// Remove car from customer lot
				Car uCar = CarService.getCar(offerLook.getCarID());
				Car removePurchase = new Car(uCar.getCarID(), uCar.getCarMake(), uCar.getCarModel(), uCar.getPriceTotal(),
						1);
				CarService.updateCar(removePurchase);
				// Reject all other offers for same car
				Offer rejectOffers = new Offer(0, "", uCar.getCarID(), 0.0, 0, "PENDING");  // Reject all other pending offers!!
//				int offerID, String userName, int carID, double offerAmt, int offerMos, String offerStatus
				OfferService.rejectOtherOffers(rejectOffers);
				System.out.println(
						offering.toString() + "\n.....#" + offering.getOfferID() + " successfully approved!!\n");

			} else if (decide.contentEquals("r")) {
				Offer offering = new Offer(offerLook.getOfferID(), offerLook.getUserName(), offerLook.getCarID(),
						offerLook.getOfferAmt(), offerLook.getOfferMos(), "REJECTED");
				OfferService.updateOffer(offering);
				System.out.println(
						offering.toString() + "\n" + "...\n..#" + offering.getOfferID() + " successfully rejected!!\n");
			}
		} catch (SQLException e) {
			System.out.println("first sql");
			try {
				dashboardChoice();
			} catch (SQLException e1) {
				UserMain.frontConsole();
			}
		}
	}

	public static void loginDashboard(String userName) throws SQLException {  

		System.out.println("\n  Welcome to your Dashboard! *" + userName + "*, ");

		dashboardChoice();
	}
}
