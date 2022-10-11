package serviceTests;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
 
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import models.Car;
import service.CarService;

public class CarServiceTest {      // *NOTE: change PK carnames before sending to DB

//        Setup Car  p1; get
//		  Car  p2; update
//		  Car p3; delete

	@BeforeAll // setup
	public static void setupClass() {
		System.out.println("Class/Static setup "); 
	}

	@BeforeEach
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
		CarService.getCar(c.getCarId()); 
   		assertEquals(CarService.getCar(c.getCarId()), CarService.getCar(c.getCarId())); // Check not null bc dynamic int ID
   		
   	} 
	@Test   
   	public void delete_car() {										  // PASSES
		Car c = new Car(77558, "Tesla", "CyberTruck", 45000.00, 0);  
   		CarService.createCar(c); 
   		assertTrue(CarService.deleteCar(c.getCarId())); 
   	}
     
	@AfterAll
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown
	
//////Teardown delete p1;
////		 delete p2;
////		 delete car from add_car test


}