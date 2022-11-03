package xyz.cryptomaven.app.models;

public class Offer {

	int offerID;
	int userID;
	String userName;
	int carId;
	double offerAmt;
	int offerMos;
	String offerStatus; // PENDING, APPROVED, REJECTED
	public Offer() { }

	public Offer(int offerID, String userName, int carId, double offerAmt, int offerMos, String offerStatus) {
//		super();
		this.offerID = offerID;
		this.userName = userName;
		this.carId = carId;
		this.offerAmt = offerAmt;
		this.offerMos = offerMos;
		this.offerStatus = offerStatus;
	}
 
	// userName integer not string passed
	public Offer(String userName, int carId, double offerAmt, int offerMos, String offerStatus) {
		this.userName = userName;
		this.carId = carId;
		this.offerAmt = offerAmt;
		this.offerMos = offerMos;
		this.offerStatus = offerStatus;
	}



	public int getOfferID() {
		return offerID;
	}

	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public double getOfferAmt() {
		return offerAmt;
	}

	public void setOfferAmt(double offerAmt) {
		this.offerAmt = offerAmt;
	}

	public int getOfferMos() {
		return offerMos;
	}

	public void setOfferMos(int offerMos) {
		this.offerMos = offerMos;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	@Override
	public String toString() {
		return "\nOffer: #" + offerID + ", Offer Status=" + offerStatus + ", Offer by: *" + userName + "*, \n   Car: #"
				+ carId + ", Offer: $" + offerAmt + " over " + offerMos + " months\n"
						+ "---------------------------";
	}
 

}
