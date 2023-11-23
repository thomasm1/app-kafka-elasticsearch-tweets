package app.mapl.bootstrap;

import app.mapl.dao.CoinDAOImpl;
import app.mapl.dao.UserDAOimpl;
import app.mapl.models.Coin;
import app.mapl.models.User;

import java.util.List;

public class ManagerCoins {

	private static ManagerCoins instance = new ManagerCoins();
	private static CoinDAOImpl coinDaoImpl = new CoinDAOImpl();

	private static UserDAOimpl userDAOimpl = new UserDAOimpl();
	private ManagerCoins() {
	}

	public static ManagerCoins getInstance() {

		return instance;
	}
	public void saveLocalUserCoin(User user, Coin bookmark) {
		ManagerUsers.getInstance().saveLocalUserCoin(user, bookmark);
	}
	public Coin createCoin(int carId, String carToken, String carSymbol, double priceTotal, int purchased) {

		Coin car = new Coin();
		car.setCoinId(carId);
		car.setCoinToken(carToken);
		car.setCoinSymbol(carSymbol);
		car.setPriceTotal(priceTotal);
		car.setPurchased(purchased);

		return car;
	}
	public List<Coin> getCoins() {
		return coinDaoImpl.getCoins();
}



}
