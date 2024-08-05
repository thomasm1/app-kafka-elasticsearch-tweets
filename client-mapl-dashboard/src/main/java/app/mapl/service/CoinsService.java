package app.mapl.service;


import app.mapl.models.Coin;

import java.util.List;


public interface CoinsService {


    public Coin createCoin(Coin c);

    public Coin getCoin(int coinId);

//    public List<Coin> getAllCoinsIOwn(String username);

    public List<Coin> getAllCoins();

    public List<Coin> getAllCoinsCust();

    public Coin updateCoin(Coin change);

    public boolean deleteCoin(int id);

    public void coinMarketViewAll();

}
