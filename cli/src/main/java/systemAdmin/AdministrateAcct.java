package systemAdmin;

public class AdministrateAcct {
    
	private int carID;
	private int userID;
	private int offerID;
    private int offerCount; 
    private double balance;
    private int offerStatus;  
    private double offerAmount;
    
    public static final int CANCELED = 0;
    public static final int PENDING = 1;
    public static final int ACCEPTED = 2;
    public static final int DECLINED = 3;

    public AdministrateAcct( int carID, int userID,  int offerID, double balance, int offerStatus, int offerCount) { 
        this.carID = carID;
        this.userID = userID;
        this.offerID = offerID;
    	this.balance = balance;
        this.offerStatus = offerStatus;
        this.offerCount = offerCount;  
    }
  

	public int getCarID() {
		return carID;
	}


	public void setCarID(int carID) {
		this.carID = carID;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getOfferID() {
		return offerID;
	}


	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}


	public int getOfferCount() {
		return offerCount;
	}


	public void setOfferCount(int offerCount) {
		this.offerCount = offerCount;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getOfferStatus(int offerStatus) {
//		case offerStatus = 0 => CANCELED;
//		case offerStatus = 1 => PENDING;
//		case offerStatus = 2 => ACCEPTED;
//		case offerStatus = 3 => DECLINED;
		return offerStatus;
	}
 
	public void setOfferStatus(int offerStatus) {
//		case offerStatus = 0 => CANCELED;
//		case offerStatus = 1 => PENDING;
//		case offerStatus = 2 => ACCEPTED;
//		case offerStatus = 3 => DECLINED;
		this.offerStatus = offerStatus;
	} 

//    public double addToAccnt( String carID, double priceTotal) {
    	// getPriceTotal(offerAmount) {
//    		balance += offerAmount;
//    	} 
//    } 

    
    

    
 

}
