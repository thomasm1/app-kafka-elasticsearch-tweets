package app.mapl.service;

import app.mapl.dao.CoinDAO;
import app.mapl.dao.CoinDAOimpl;
import app.mapl.models.Coin;

import java.util.List;

public class CoinService {

	public static CoinDAO coindao = new CoinDAOimpl();
 
//	 * This method is now a static version of the getCoin() method. To get a coin by
//	 * its ID, call: CoinService.getCoin(id);
	 
	public static boolean createCoin(Coin c) {
		return coindao.createCoin(c);
	}

	public static Coin getCoin(int id) {
		return coindao.getCoin(id);
	};

	public static List<Coin> getAllCoinsIOwn(String username) {
		return coindao.getAllCoinsIOwn(username);
	};

	public static List<Coin> getAllCoins() {
		return coindao.getAllCoins();
	};

	public static List<Coin> getAllCoinsCust() {
		return coindao.getAllCoinsCust();
	};

	public static boolean updateCoin(Coin change) {
		return coindao.updateCoin(change);
	}

	public static boolean deleteCoin(int id) {
		return coindao.deleteCoin(id);
	}

	public static void coinMarketViewAll() {
		System.out.println(getAllCoinsCust());
	};

}
