package app.mapl.systemAdmin;

public class AdminLotState {

	private String date; 
	private int coinMarketsCount;

	public AdminLotState(String date, int coinMarketsCount) {// , boolean ifPurchased, int coinQuantity
		this.setDate(date);
		this.coinMarketsCount = coinMarketsCount; 
	}

	public int addCoin(int coinQuantity) { // String coinMake, String coinModel, double priceTotal
		coinMarketsCount += coinQuantity;
		return coinMarketsCount;
	}

	// The purchased argument is true if admin is removing as a purchase
	// It's false if admin is removing for no-sale or recall...
	public int removeCoin(int coinQuantity, boolean ifPurchased) { // ,
		coinMarketsCount -= coinQuantity;
		return coinMarketsCount;
	}

	public   int getCoinCount() {
		return coinMarketsCount; 
//		System.out.println(coinMarketsCount);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
