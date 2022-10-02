package db;

import java.util.HashMap;
import java.util.Map;

import models.Groot;

public class DB {

	public static Map<Integer, Groot> team = new HashMap<Integer, Groot>();
	
	static {
		Groot p1 = new Groot(1, "Bulbasaur", "Grass/Poision");		
		Groot p2 = new Groot(2, "Pikachu", "Electric");
		Groot p3 = new Groot(3, "Jigglypuff", "Fairy");
		
		team.put(1, p1);
		team.put(2, p2);
		team.put(3, p3);
	}
	
}

//import java.util.HashMap;
//import java.util.Map;
//
//import models.Car;
//import models.User;
//import models.Offer;
//
//public class DB {
//
//	public static Map<Integer, Car> cars = new HashMap<Integer, Car>();
//	public static Map<Integer, User> users = new HashMap<Integer, User>();
//	public static Map<Integer, Offer> offers = new HashMap<Integer, Offer>();
//	/*
//	 * This class will eventually be replaced. This will be a way of storing
//	 * information for the models. This information will be lost when terminating
//	 * the application. SQL and JDBC will replace this with a connection to a real
//	 * database to persist the information.
//	 */
//	static { // Block Scope: code that executes very first time class is loaded
//				// -->pre-fabricated!
//
//		////////////////////// CAR
//		Car newTesla = new Car(22, "Tesla", "Cyber-Truck", 37000.99, 0 );
//		System.out.println("\n");
//
//		Car newJeep = new Car(101, "Jeep", "Wrangler", 24000.01, 0 );
//		System.out.println("\n");
//
//		Car newFord = new Car(102, "Ford", "Fusion", 23000.99, 0 );
//		System.out.println("\n");
//
//		cars.put(101, newTesla);
//		cars.put(201, newJeep);
//		cars.put(301, newFord);
//		
//		////////////////////// USER 
//	//(int userID, String user, String pass, String fullName, boolean isOwner, int offerCount)
//		User templateOfferer = new User(1, "user", "password", "Gim Offers", 0 ,0 );
//		User templateOwner = new User(2, "user0", "password", "Genny Owner", 1, 1  );
//		users.put(1, templateOfferer);
//		users.put(2, templateOwner);
//		
//		////////////////////// OFFER
//	//(int offerID, int userID, int carID, int offerCount, double offerAmt, int offerMos) 
//		Offer gimsOffer = new Offer(99, 99, 101, 9999.00, 99, "PENDING"); 
//		offers.put(1, gimsOffer); 
//		// static block is code that executes the very
//		// first time a class is loaded. Therefore this
//		// will be pre-populated cars for testing purposes.
//
//	}
//}
