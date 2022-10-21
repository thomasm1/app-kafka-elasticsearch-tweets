package xyz.cryptomaven.app.dataLoader;

import xyz.cryptomaven.app.dao.CarDAOimpl;
import xyz.cryptomaven.app.dao.OfferDAOimpl;
import xyz.cryptomaven.app.models.Car;
import xyz.cryptomaven.app.models.Offer;

import java.util.List;

public class CarManager {

	private static CarManager instance = new CarManager(); 
	private static CarDAOimpl carDaoImpl = new CarDAOimpl();

	private static OfferDAOimpl offerDaoImpl= new OfferDAOimpl();
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
	public List<Car> getCars() {
		return carDaoImpl.getCars(); 
}


	public Offer createOffer(int offerID, String userName, int carId, double offerAmt, int offerMos, String offerStatus) {
		Offer offer = new Offer();
		offer.setOfferID(offerID);
		offer.setUserName(userName);
		offer.setCarId(carId);
		offer.setOfferAmt(offerAmt);
		offer.setOfferMos(offerMos);
		offer.setOfferStatus(offerStatus);
		return offer;
	}

	public List<Offer> getOffers() {
		return offerDaoImpl.getOffers();
	}
}
