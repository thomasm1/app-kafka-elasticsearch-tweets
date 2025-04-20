package xyz.cryptomaven.rest.services;


import xyz.cryptomaven.rest.models.dto.CoinDto;

import java.util.List;
import java.util.Optional;


public interface CoinService {


    CoinDto createCoin(CoinDto cd);

      Optional<CoinDto>  getCoinById(Long id);

    //    @Autowired
    //    public List<Coin> getAllCoinIOwn(String username) {
    //        return null; //(List<Coin>)  coinRepository.findByUsername(username);
    //    }
    List<CoinDto> getAllCoin();




  CoinDto updateCoin(CoinDto change);

    boolean deleteCoin(Long id);

    void createCoinCLI(CoinDto createdCoin);
}
