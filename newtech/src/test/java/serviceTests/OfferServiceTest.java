package serviceTests; 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.User;
import service.UserService;
import models.Car;
import service.CarService;
import models.Offer;
import service.OfferService;

public class OfferServiceTest {      // *NOTE: change PK offernames before sending to DB

//        Setup Offer  p1; get
//		  Offer  p2; update
//		  Offer p3; delete

	@org.junit.BeforeClass // setup
	public static void setupClass() {
		System.out.println("Class/Static setup "); 
	}

	@org.junit.Before
	public void setup() {
		System.out.println("Method/Instance setup ");
	}

    @org.junit.Test   
	public void add_new_offer() {
    	Car c = new Car(757357, "Tesla", "CyberTruck", 45000.00, 0); // make foreign-key car
    	CarService.createCar(c);									// Only non-passing test
		
    	User u = new User(99, "x455491", "passWordX", null, 0, 0);   // PASSES
		UserService.createUser(u); 
		
    	Offer o = new Offer(23230, "x455491", 757357, 1110.0, 0, "PENDING");    // PASSES
		assertTrue(OfferService.createOffer(o));
		
	}
    @org.junit.Test   
   	public void update_offer() {
   		Offer o = new Offer(23230, "x455491", 757357, 1110.0, 0, "PENDING");  // PASSES
   		assertTrue(OfferService.updateOffer(o));
   		
   	}
    @org.junit.Test   
   	public void get_offer() {
   		Offer o = new Offer(23230, "x455491", 757357, 1110.0, 0, "PENDING");   // PASSES
		OfferService.createOffer(o); 
   		assertEquals("PENDING", o.getOfferStatus());
   		
   	} 

	@org.junit.Test   
   	public void delete_offer() {										  // PASSES
   		Offer o = new Offer(23230, "x455491", 757357, 1110.0, 0, "PENDING");
   		OfferService.createOffer(o); 
   		assertTrue(OfferService.deleteOffer(o.getOfferID()));
   		
   	}
    
	@org.junit.After
	public void tearDown() {
		System.out.println("After Class executing ...");
	} // teardown

	@org.junit.AfterClass
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown
	
//////Teardown delete p1;
////		 delete p2;
////		 delete offer from add_offer test


}