package modelTests;

import org.junit.Test;

import models.Car;

import static org.junit.Assert.*;
import org.junit.Before;

public class CarModelTest {
//int carID, String carMake, String carModel, double priceTotal, int carCount, boolean purchased, int status

	@Before
	public void setup() {
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		System.out.println(newCar);
	}

	@Test
	public void getCarID() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		assertEquals(1010, newCar.getCarID());
	}

	@Test
	public void setCarID() {										  // PASSES
		Car newCar = new Car(1010, "Jeep", "Wrangler", 24000.01, 0);
		newCar.setCarID(1010);
		assertEquals(1010, newCar.getCarID());
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