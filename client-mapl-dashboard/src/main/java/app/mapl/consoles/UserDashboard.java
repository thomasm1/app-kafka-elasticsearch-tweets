package app.mapl.consoles;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.mapl.models.Coin;
import app.mapl.models.OfferLogic;
import app.mapl.models.Offer;
import app.mapl.service.*;
import app.mapl.systemUser.UserProfile;

import static app.mapl.util.constants.Cmds.*;

public class UserDashboard {


	private static final int MENU_FIRST = 0;
	public static final int MENU_LAST = 6;

	// RECURSIVE LOOP, breaks out at option 0

	/**
	 *
	 * @param username
	 */
	public static void dashboardChoice(String username) {
		System.out.println("\n Welcome to your Dashboard! *" + username + "*, ");
		System.out.println(WHAT_TO_DO);
		System.out.println("1: "+VIEW_MY_CARS);
		System.out.println("2: "+VIEW_ALL_CARS);
		System.out.println("3: "+VIEW_CAR_DETAILS);
		System.out.println("4: "+MAKE_AN_OFFER);
		System.out.println("5: "+MAKE_INQUIRY_MY_OFFERS);
		System.out.println("6: "+EDIT_MY_PROFILE);
		System.out.println("0: "+LEAVE_MENU);

try(Scanner scan = new Scanner(System.in)) {
	int val = scan.nextInt();
	if (val < MENU_FIRST || val > MENU_LAST) {
		System.out.println(OOPS_OPTIONS);
		val = scan.nextInt();
		scan.nextLine();
	} else {
		switch (val) {
		case 1: {
			try {
				System.out.println("_____Coins I own:_______");
				System.out.println(OfferLogicService.getInstance().getAllOfferLogic());
				List<Coin> coinsList = new ArrayList<>();
				
				List<OfferLogic> eList = OfferLogicService.getInstance().getAllOfferLogic();
	 			for(OfferLogic el: eList)  {
					  if (el.getUsername().equals(username)) {
						  coinsList.add(CoinService.getCoin(el.getCoinid()));
					}
				}
				System.out.println(coinsList);
//				}
			} catch (Exception e) {
				dashboardChoice(username);
			}
			dashboardChoice(username);
			break;
		}
		case 2: {
			try {
				List<Coin> coinList = CoinService.getAllCoinsCust();
				System.out.println(COINMARKET_TITLE);
				System.out.println(coinList);
				System.out.println("4: "+PRESS_DIGIT);
				System.out.println();
			} catch (Exception e) {
				dashboardChoice(username);
			}
			dashboardChoice(username);
		}
		case 3: {
			try {
				List<Coin> coinList = CoinService.getAllCoinsCust();
				scan.nextLine();
				System.out.println("Which coin #?");
				int id = scan.nextInt();
				scan.nextLine();
				Coin newest = CoinService.getCoin(id);
				System.out.println(newest);
				System.out.println("\n Coin #" + id + 
										NICE + PRESS_DIGIT + FOUR);
			} catch (Exception e) {
				dashboardChoice(username);
			}
			dashboardChoice(username);
		}
		case 4: {
			try {
				List<Coin> coinList = CoinService.getAllCoinsCust();
				System.out.println("e-Coins Lot:");
				System.out.println(coinList);
				System.out.println("\nOk, type in the Coin ID to begin.\n"
						+ " ...change your mind? press 'no' (or any letter)");
				val = scan.nextInt();

				Coin newest = CoinService.getCoin(val);
				System.out.println("Voila, coin id #" + val + "\n");
				System.out.println(newest);
				
				scan.nextLine();
				System.out.println("\nHow much, $xxxx.xx can you put down?  ");
				double down = scan.nextDouble();
				while (down > newest.getPriceTotal()) {
					System.out.println("Oops, that's more than the coin price!");
					down = scan.nextDouble();
				}
				scan.nextLine();
				System.out.println(HOW_MANY_MONTHS);
				int mos = scan.nextInt();
				Offer offering = new Offer(777, username, val, down, mos, "PENDING");
				 
				System.out.println(OfferService.createOffer(offering));
				System.out.println(NICE+ " $" + down + " down, over *" + mos + "* months\n"
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
		case 6: {
			try { // pass in Loggeed in user object for Profile Edit
//				User user = UserService.getUser(username);
				UserProfile.editProfile(UserService.getUser(username));

			} catch (Exception e) {
				dashboardChoice(username);
			}
			dashboardChoice(username);
		}
		case 0: {
			System.out.println(GOOD_BYE);
			MainDashboard.mainConsole();
			break;
		}
		}
	}
	dashboardChoice(username);
}

	};

}
