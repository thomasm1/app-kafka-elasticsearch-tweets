package xyz.cryptomaven.app;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import xyz.cryptomaven.app.models.Car;

 

public class CarModelTest {
//int carId, String carMake, String carModel, double priceTotal, int carCount, boolean purchased, int status
	@BeforeAll // setup
	public static void setupClass() {
		System.out.println("Class/Static setup "); 
	}

	@BeforeEach
	public void setup() {
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		System.out.println(newCar);
	}

	@Test
	public void getCarId() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		assertEquals(1010, newCar.getCarId());
	}

	@Test
	public void setCarId() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		newCar.setCarId(1010);
		assertEquals(1010, newCar.getCarId());
	}

	@Test
	public void getCarMake() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		assertEquals("Jeep", newCar.getCarMake());
		System.out.println("Car Make: " + newCar.getCarMake());
	}

	@Test
	public void setCarMake() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		newCar.setCarMake(null);
		assertNull(null, newCar.getCarMake());
		System.out.println(newCar.getCarMake());
	}

	@Test
	public void getCarModel() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		String whatsModel = newCar.getCarModel();
		System.out.println("Car Model: " + whatsModel);
	}

	@Test
	public void setCarModel() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		newCar.setCarModel("Cherokee");
		assertEquals("Cherokee", newCar.getCarModel());
		System.out.println("New model : " + newCar.getCarModel());
	}

	@Test
	public void isPurchased() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		assertEquals(0, newCar.isPurchased());
		System.out.println("Car Bought? : " + newCar.isPurchased());
	}

}