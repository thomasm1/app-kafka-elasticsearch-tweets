package app.mapl.service;


import app.mapl.dto.CoinDto;
import app.mapl.models.Coin;

import java.util.List;


public interface CoinsService {


    public CoinDto createCoin(CoinDto c);

    public CoinDto getCoin(int coinId);

    public List<CoinDto> getAllCoins();

    public List<CoinDto> getAllCoinsCust();

    public CoinDto updateCoin(CoinDto change);

    public boolean deleteCoin(int id);

    public void coinMarketViewAll();

    List<CoinDto> getAllCoinsIOwn(String email);

    // CLI
    public Coin getCoinCLI(int coinId);
    public List<Coin> getAllCoinsCustCLI();
}
