package app.mapl.service;

import app.mapl.dao.CoinDAOImpl;
import app.mapl.models.Coin;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.function.Predicate;
import java.util.stream.Collectors;


// Like Singleton Managers, This Service is a Controllers return singletons

@Service
@Profile(value={"dev"})
@RequiredArgsConstructor
public class CoinsServiceImpl {
	private final static Logger log = LoggerFactory.getLogger(CoinsServiceImpl.class);
    private static CoinDAOImpl coindao;

//
//	private static CoinsServiceImpl instance = new CoinsServiceImpl();
//	private CoinsServiceImpl() {}
//	public static CoinsServiceImpl getInstance() {
//		return instance;
//	}

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

	public static List<Coin> getAllCoinsByCoinToken(String token) {
		Predicate<? super Coin> predicate =
				c -> c.getCoinToken().equals(token);

		List<Coin> coins = coindao.getAllCoins();

		return coins.stream().filter(predicate).collect(Collectors.toList());
	};

	public static boolean updateCoin(Coin change) {
		return coindao.updateCoin(change);
	}

	public static boolean deleteCoin(int id) {
		return coindao.deleteCoin(id);
	}

	public static void coinMarketViewAll() {
		System.out.println(coindao.getAllCoinsCust());
	};

	public static void setCoindao(CoinDAOImpl coindao) {
		CoinsServiceImpl.coindao = coindao;
	}

}
