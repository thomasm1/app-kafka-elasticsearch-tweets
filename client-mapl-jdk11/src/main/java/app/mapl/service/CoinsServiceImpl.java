package app.mapl.service;


import app.mapl.models.Coin;
import app.mapl.repositories.CoinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinsServiceImpl implements CoinsService {

@Autowired
private CoinsRepository coinsRepository;
    @Override
    public Coin createCoin(Coin c) {
         return  coinsRepository.save(c);
    }
    @Override
    public Coin getCoin(int coinId) {
    try {
            return coinsRepository.findById(coinId).get();
        } catch (Exception e) {
            return null;
        }
    }
//    @Autowired
//    public List<Coin> getAllCoinsIOwn(String username) {
//        return null; //(List<Coin>)  coinsRepository.findByUsername(username);
//    }
    @Override
    public List<Coin> getAllCoins() {
        return (List<Coin>) coinsRepository.findAll();
    }
    @Override
    public List<Coin> getAllCoinsCust() {
        return null; // (List<Coin>) coinsRepository.findAll();
    }
    @Override
    public Coin updateCoin(Coin change) {
         return   coinsRepository.save(change);
    }
    @Override
    public boolean deleteCoin(int coinId) {

        try {
            Coin c = coinsRepository.findById(coinId).get();
            coinsRepository.delete(c);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public void coinMarketViewAll() {
        System.out.println(getAllCoinsCust());
    }

}
