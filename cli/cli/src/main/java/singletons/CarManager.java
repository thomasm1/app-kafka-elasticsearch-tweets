package singletons;

import db.DataStore;
import models.Car;
import models.User;

public class CarManager {

	private static CarManager instance = new CarManager(); 
	private CarManager() {
	}

	public static CarManager getInstance() {

		return instance;
	}

	public Car createCar(int carId, String carMake, String carModel, double priceTotal, int purchased) {
	 

		Car car = new Car(); 
		car.setCarId(carId);
		car.setCarMake(carMake);
		car.setCarModel(carModel);
		car.setPriceTotal(priceTotal); 
		car.setPurchased(purchased);  
		
		return car; 
	}
	public Car[] getCars() { 
		return DataStore.getCars(); 
}
}
