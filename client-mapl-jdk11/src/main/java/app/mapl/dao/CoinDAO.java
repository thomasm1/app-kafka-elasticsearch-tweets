package app.mapl.dao;

import app.mapl.models.Coin;

import java.util.List;

public interface CoinDAO { 
	
	public boolean createCoin(Coin c); // void
	public Coin getCoin(int id);
	public List<Coin> getAllCoins();
	public List<Coin> getAllCoinsCust();
	public List<Coin> getAllCoinsIOwn(String username);
	public boolean updateCoin(Coin change); // void
	public boolean deleteCoin(int id); // void 
	
	public List<Coin> getCoins();
	 
	
} 