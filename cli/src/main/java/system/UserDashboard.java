package system;
 
import java.util.List;
import java.util.Scanner;

import constants.Cmds;
import controllers.BookmarkController;
import models.Bookmark;
import models.Car;
import models.Offer; 
import service.CarService;
import service.ElectroLotService;
import service.OfferService;

public class UserDashboard {

	
	private static final int MENU_FIRST = 0;
	public static final int MENU_LAST = 6;

	Integer val;

	// RECURSIVE LOOP, breaks out at option 0
	public static void dashboardChoice(String username) {
		System.out.println(Cmds.WHAT_TO_DO+
				Cmds.ONE+Cmds.VIEW_MY_CARS+
				Cmds.TWO+Cmds.VIEW_ALL_CARS+
				Cmds.THREE+Cmds.VIEW_CAR_DETAILS+
				Cmds.FOUR + Cmds.MAKE_AN_OFFER +
				Cmds.FIVE + Cmds.MAKE_INQUIRY_MY_OFFERS +
				Cmds.ZERO + Cmds.LEAVE_MENU ); 

		Scanner scan = new Scanner(System.in);
		int val = scan.nextInt();

try {
	if (val < MENU_FIRST || val > MENU_LAST) {
		System.out.println(Cmds.OOPS_OPTIONS);
		val = scan.nextInt();
		scan.nextLine();
	} else {
		switch (val) {
		case 1: {
			try {
				System.out.println("_____Cars I own:_______");
//				List<Car> carList = CarService.getAllCarsIOwn(username);
				
				System.out.println(ElectroLotService.getAllElectroLot(username));
				ElectroLotService.getAllElectroLot(username);

//				List<ElectroLot> electroList = ElectroLotService.getAllElectroLot(username);
//				System.out.println(electroList);
//				System.out.println(carList);

//				System.out.println("\n_____My financing details:_______");
//				List<Offer> offerList = OfferService.getAllOffersCust(username);
//				for (Offer offer : offerList) {
//					System.out.println(offer);
//				}
			} catch (Exception e) {
				dashboardChoice(username);
			}
			dashboardChoice(username);
			break;
		}
		case 2: {
			try {
				List<Car> carList = CarService.getAllCarsCust();
				System.out.println(Cmds.CARLOT_TITLE);
				System.out.println(carList);
				System.out.println(Cmds.PRESS_DIGIT + Cmds.FOUR + Cmds.BR);
			} catch (Exception e) {
				dashboardChoice(username);
			}
			dashboardChoice(username);
		}
		case 3: {
			try { 

				List<Car> carList = CarService.getAllCarsCust();
				scan.nextLine();
				System.out.println("Which car #?");
				int id = scan.nextInt();
				scan.nextLine();
				Car newest = CarService.getCar(id);
				System.out.println(newest);
				System.out.println("\n Car #" + id + 
										Cmds.NICE + Cmds.PRESS_DIGIT + Cmds.FOUR);
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
				System.out.println(Cmds.HOW_MANY_MONTHS);
				int mos = scan.nextInt();
				Offer offering = new Offer(777, username, val, down, mos, "PENDING");
				 
				System.out.println(OfferService.createOffer(offering));
				System.out.println(Cmds.NICE+ " $" + down + " down, over *" + mos + "* months\n"
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
			System.out.println(Cmds.GOOD_BYE);
			MainDashboard.console();
			break;
		}
		}
	}
	dashboardChoice(username);
} finally {
	scan.close(); 
}

	};

	public static void loginDashboard(String userName, String firstName) {
		System.out.println("\n Welcome to your Dashboard! *" + firstName + "*, ");
		dashboardChoice(userName);

	}
}
