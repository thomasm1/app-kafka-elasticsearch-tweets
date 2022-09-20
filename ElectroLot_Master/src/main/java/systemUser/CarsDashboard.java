package systemUser;

import java.sql.SQLException;
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
import service.ControllerService;

public class CarsDashboard {

	Integer val;

	public static void dashboardChoice(String username) {
		System.out.println("What would you like to do? \n " + "1.) View my cars\n " + "2.) View all cars\n "
				+ "3.) View a car in detail\n " + "4.) Find one you like? Make an offer!\n "
				+ "5.) Inquire about my existing offers\n " + "0.) To leave, press 0");
//OK		* As a customer, I can view the cars on the lot. (1/2)
//OK		* As a customer, I can make an offer for a car. (1/2)
//OK		* As a customer, I can view the cars that I own. 
//OK		* As a customer, I can view my remaining payments for a car.

		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();

		if (val < 0 || val > 6) {
			System.out.println("OOPS! options are betwen 0 and 6 :(");
			val = scan.nextInt();
			scan.nextLine();
		} else {
			switch (val) {
			case 1: {
				try {
					System.out.println("_____Cars I own:_______");
//					List<Car> carList = CarService.getAllCarsIOwn(username);
					
					System.out.println(ElectroLotService.getAllElectroLot(username));
					ElectroLotService.getAllElectroLot(username);

//					List<ElectroLot> electroList = ElectroLotService.getAllElectroLot(username);
//					System.out.println(electroList);
//					System.out.println(carList);

//					System.out.println("\n_____My financing details:_______");
//					List<Offer> offerList = OfferService.getAllOffersCust(username);
//					for (Offer offer : offerList) {
//						System.out.println(offer);
//					}
				} catch (Exception e) {
					dashboardChoice(username);
				}
				dashboardChoice(username);
			}
			case 2: {
				try {
					List<Car> carList = CarService.getAllCarsCust();
					System.out.println("I-*heart*-electric cars: CarLot view...");
					System.out.println(carList);
					System.out.println("\n There they are!, press 4 to make an offer... \n ");
				} catch (Exception e) {
					dashboardChoice(username);
				}
				dashboardChoice(username);
			}
			case 3: {
				try {
					scan.nextLine();
					System.out.println("Which car #?");
					int id = scan.nextInt();
					scan.nextLine();
					Car newest = CarService.getCar(id);
					System.out.println(newest);
					System.out.println("\n Car #" + id + " sure is nice! Press 4 to make an offer... \n ");
				} catch (Exception e) {
					dashboardChoice(username);
				}
				dashboardChoice(username);
			}
			case 4: {
				try {
					List<Car> carList = CarService.getAllCarsCust();
					System.out.println("e-Cars Lot:");
					System.out.println(carList);
					System.out.println("\nOk, type in the Car ID to begin.\n"
							+ " ...change your mind? press 'no' (or any letter)");
					val = scan.nextInt();

					Car newest = CarService.getCar(val);
					System.out.println("Voila, car id #" + val + "\n");
					System.out.println(newest);
					
					scan.nextLine();
					System.out.println("\nHow much, $xxxx.xx can you put down?  ");
					double down = scan.nextDouble();
					while (down > newest.getPriceTotal()) {
						System.out.println("Oops, that's more than the car price!");
						down = scan.nextDouble();
					}
					scan.nextLine();
					System.out.println("and how many months to pay remainder?");
					int mos = scan.nextInt();
					Offer offering = new Offer(777, username, val, down, mos, "PENDING");
					 
					System.out.println(OfferService.createOffer(offering));
					System.out.println(" GREAT!.. $" + down + " down, over *" + mos + "* months\n"
							+ "We'll let you know in less than 24 hours!!\n");
				} catch (Exception e) {
					dashboardChoice(username);
				}
				dashboardChoice(username);
			}
			case 5: {
				try {
					List<Offer> offerList = OfferService.getAllOffersCust(username);

					for (Offer offer : offerList) {
						System.out.println(offer);
					}

				} catch (Exception e) {
					dashboardChoice(username);
				}
				dashboardChoice(username);
			}
			case 0: {
				System.out.println("So sorry to see you leave! Please come back soon!!\n"); 
					System.exit(0); 
				dashboardChoice(username);
			}
			}
		}
		dashboardChoice(username);
		scan.close();

	};

	public static void loginDashboard(String userName) { 

		System.out.println("\n Welcome to your Dashboard! *" + userName + "*, ");
 
		dashboardChoice(userName);

	}
}
