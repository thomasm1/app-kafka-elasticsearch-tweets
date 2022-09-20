package models;

public class Offer {

	int offerID;
	String userName;
	int carID;
	double offerAmt;
	int offerMos;
	String offerStatus;

	public Offer(int offerID, String userName, int carID, double offerAmt, int offerMos, String offerStatus) {
//		super();
		this.offerID = offerID;
		this.userName = userName;
		this.carID = carID;
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

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
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
				+ carID + ", Offer: $" + offerAmt + " over " + offerMos + " months\n"
						+ "---------------------------";
	}

}
