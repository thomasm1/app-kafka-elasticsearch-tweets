package app.mapl.serviceTests;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import app.mapl.models.User;
import app.mapl.service.CoinService;
import app.mapl.service.UserService;
import app.mapl.models.Coin;
import app.mapl.models.Offer;
import app.mapl.service.OfferService;

public class OfferServiceTest {      // *NOTE: change PK offernames before sending to DB

//        Setup Offer  p1; get
//		  Offer  p2; update
//		  Offer p3; delete
	int rand;
	@BeforeAll // setup
	public static void setupClass() {
		System.out.println("Class/Static setup "); 
	}

	@BeforeEach
	public void setup() {
		int num = 711;
		rand = (int) ((int) num * Math.random());
		System.out.println("Method/Instance setup "+rand);
	}

    @Test   
	public void add_new_offer() {
    	Coin c = new Coin(7577-rand, "Tesla", "CyberTruck", 45000.00, 0); // make foreign-key coin
    	CoinService.createCoin(c);// Only non-passing test

    	User u = new User("testtest"+rand, "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net",
				"photoPath",
				"userGroup",
				0,
				1,
				"id");
		UserService.createUser(u);
    	Offer o = new Offer(u.getUserName(), c.getCoinId(), 1110.0, 0, "PENDING");    // PASSES
		assertTrue(OfferService.createOffer(o));
		OfferService.deleteOffer(o.getOfferID());
		CoinService.deleteCoin(c.getCoinId());
		UserService.deleteUser(u.getUserName());
		
	}
    @Test   
   	public void update_offer() {
   		Offer o = new Offer(23230-rand, "x455491", 757357, 1110.0, 0, "PENDING");  // PASSES
   		assertTrue(OfferService.updateOffer(o));
   		
   	}
    @Test   
   	public void get_offer() {
   		Offer o = new Offer(23230-rand, "x455491", 757357, 1110.0, 0, "PENDING");   // PASSES
		OfferService.createOffer(o); 
   		assertEquals("PENDING", o.getOfferStatus());
   		
   	} 

	@Test   
   	public void delete_offer() {										  // PASSES
   		Offer o = new Offer(23230-rand, "x455491", 757357, 1110.0, 0, "PENDING");
   		OfferService.createOffer(o); 
   		assertTrue(OfferService.deleteOffer(o.getOfferID()));
   		
   	}
    
	@AfterEach
	public void tearDown() {
		System.out.println("After Class executing ...");
	} // teardown

	@AfterAll
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown
	
//////Teardown delete p1;
////		 delete p2;
////		 delete offer from add_offer test


}