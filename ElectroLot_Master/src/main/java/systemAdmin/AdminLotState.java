package systemAdmin;

public class AdminLotState {

	private String date; 
	private int carLotCount;

	public AdminLotState(String date, int carLotCount) {// , boolean ifPurchased, int carQuantity
		this.setDate(date);
		this.carLotCount = carLotCount; 
	}

	public int addCar(int carQuantity) { // String carMake, String carModel, double priceTotal
		carLotCount += carQuantity;
		return carLotCount;
	}

	// The purchased argument is true if admin is removing as a purchase
	// It's false if admin is removing for no-sale or recall...
	public int removeCar(int carQuantity, boolean ifPurchased) { // ,
		carLotCount -= carQuantity;
		return carLotCount;
	}

	public   int getCarCount() {
		return carLotCount; 
//		System.out.println(carLotCount);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
