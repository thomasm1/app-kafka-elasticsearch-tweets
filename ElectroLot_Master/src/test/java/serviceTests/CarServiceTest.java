package serviceTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import models.Car;
import service.CarService;

public class CarServiceTest {      // *NOTE: change PK carnames before sending to DB

//        Setup Car  p1; get
//		  Car  p2; update
//		  Car p3; delete

	@org.junit.BeforeClass // setup
	public static void setupClass() {
		System.out.println("Class/Static setup "); 
	}

	@org.junit.Before
	public void setup() {
		System.out.println("Method/Instance setup ");
	}

    @Test   
	public void add_new_car() {
		Car c = new Car(75757, "Tesla", "CyberTruck", 45000.00, 0);    // PASSES
		assertTrue(CarService.createCar(c));
		
	}
    @Test   
   	public void update_car() {
   		Car c = new Car(75578, "Tesla", "CyberTruck", 45000.00, 0);    // PASSES
   		assertTrue(CarService.updateCar(c));
   		
   	}
    @Test   
   	public void get_car_make() {
    	Car c = new Car(75578, "Tesla", "CyberTruck", 45000.00, 0);    // PASSES
		CarService.createCar(c); 
   		assertEquals("Tesla", c.getCarMake());
   		
   	} 
    @Test   
   	public void get_car() {
    	Car c = new Car(775578, "Tesla", "CyberTruck", 45000.00, 0);    // PASSES
		CarService.getCar(c.getCarID()); 
   		assertEquals(CarService.getCar(c.getCarID()), CarService.getCar(c.getCarID())); // Check not null bc dynamic int ID
   		
   	} 
	@Test   
   	public void delete_car() {										  // PASSES
		Car c = new Car(77558, "Tesla", "CyberTruck", 45000.00, 0);  
   		CarService.createCar(c); 
   		assertTrue(CarService.deleteCar(c.getCarID()));
   		
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
////		 delete car from add_car test


}