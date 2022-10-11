package service;

import java.util.List;

import dao.CarDAO;
import dao.CarDAOimpl;
import models.Car;

public class CarService {

	public static CarDAO cardao = new CarDAOimpl();
 
//	 * This method is now a static version of the getCar() method. To get a car by
//	 * its ID, call: CarService.getCar(id);
	 
	public static boolean createCar(Car c) {
		return cardao.createCar(c);
	}

	public static Car getCar(int id) {
		return cardao.getCar(id);
	};

	public static List<Car> getAllCarsIOwn(String username) {
		return cardao.getAllCarsIOwn(username);
	};

	public static List<Car> getAllCars() {
		return cardao.getAllCars();
	};

	public static List<Car> getAllCarsCust() {
		return cardao.getAllCarsCust();
	};

	public static boolean updateCar(Car change) {
		return cardao.updateCar(change);
	}

	public static boolean deleteCar(int id) {
		return cardao.deleteCar(id);
	}
}
