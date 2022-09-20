package models;

public class Car {

	int carID;
	String carMake;
	String carModel;
	double priceTotal;
	int purchased;

	/*
	 * Java Object representation of a table in DB.
	 * Tables: User, Payments, Offers, 
	 * *purchased = 1 ; (not) purchased = 0
	 */
	public Car() {
		super();
	}

	public Car(int carID, String carMake, String carModel, double priceTotal, int purchased) {
		super();

		this.carID = carID;
		this.carMake = carMake;
		this.carModel = carModel;
		this.priceTotal = priceTotal;
		this.purchased = purchased;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public int isPurchased() {
		return purchased;
	}

	public void setPurchased(int purchased) {
		this.purchased = purchased;
	}

	@Override
	public String toString() {
		return "\nCar ID:" + carID + ", car Make:" + carMake + ", car Model:" + carModel + ", priceTotal:" + priceTotal
				+ ", 1 = purchased:" + purchased + "]\n"
						+ "------------------------------";
	}

}
