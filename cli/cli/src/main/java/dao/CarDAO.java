package dao;

import java.util.List;

import models.Car; 

public interface CarDAO { 
	
	public boolean createCar(Car c); // void
	public Car getCar(int id);
	public List<Car> getAllCars();
	public List<Car> getAllCarsCust();
	public List<Car> getAllCarsIOwn(String username);
	public boolean updateCar(Car change); // void
	public boolean deleteCar(int id); // void 
	 
	
} 