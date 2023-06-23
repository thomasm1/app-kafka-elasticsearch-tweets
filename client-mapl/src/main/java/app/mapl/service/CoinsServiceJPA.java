package app.mapl.service;


import app.mapl.dto.CoinDto;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.mapper.CoinMapper;
import app.mapl.models.Coin;
import app.mapl.repositories.CoinsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class CoinsServiceJPA implements CoinsService {
    private ObjectMapper objectMapper;
    private   CoinsRepository coinsRepository;

    private   CoinMapper coinMapper;

    public CoinsServiceJPA(CoinsRepository coinsRepository, CoinMapper coinMapper) {
        this.coinsRepository = coinsRepository;
        this.coinMapper = coinMapper;
    }

    public CoinsServiceJPA() {

    }

    /**
     * @param  cd
     * @return CoinDto
     */

    @Override
    public CoinDto createCoin(CoinDto cd) {
        Coin coin = coinMapper.toEntity(cd);
        Coin newCoin = coinsRepository.save(coin);

        CoinDto newCoinDto = coinMapper.toDto(newCoin);
        return newCoinDto;
    }
    @Override
    public CoinDto getCoin(int id) {
        Coin coin = coinsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", Integer.toString(id)));
        return coinMapper.toDto(coin);
    }
    //    @Autowired
//    public List<Coin> getAllCoinsIOwn(String username) {
//        return null; //(List<Coin>)  coinsRepository.findByUsername(username);
//    }
    @Override
    public List<CoinDto> getAllCoins() {
        List<Coin> coins = coinsRepository.findAll();
        List<CoinDto> content = coins.stream().map(coinMapper::toDto).collect(Collectors.toList());


        return content;

    }

    /**
     * @return
     */
    @Override
    public List<CoinDto> getAllCoinsCust() {
        List<Coin> coins = coinsRepository.findAll();
        List<CoinDto> content = coins.stream().map(coinMapper::toDto).collect(Collectors.toList());


        return content;
    }

    /**
     * @return
     */
    @Override
    public List<Coin> getAllCoinsCustCLI() {

        List<Coin> coins = coinsRepository.findAll();
        List<CoinDto> content = coins.stream().map(coinMapper::toDto).collect(Collectors.toList());
        return coins;
    }


    @Override
    public CoinDto updateCoin(CoinDto change) {
        try {
            Coin coinUpdate = coinMapper.toEntity(change);

            coinUpdate = coinsRepository.findById(change.getCoinId()).get();
            coinUpdate.setCoinId(change.getCoinId()); // this is the only thing that should be changed);
            coinUpdate.setCoinToken(change.getCoinToken());
            coinUpdate.setCoinSymbol(change.getCoinSymbol());
            coinUpdate.setPriceTotal(change.getPriceTotal());
            coinUpdate.setPurchased(change.getPurchased());

            Coin coinDone = coinsRepository.save(coinUpdate);

            return coinMapper.toDto(coinDone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @Override
    public boolean deleteCoin(int id) {
        try {
            coinsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     */
    @Override
    public void coinMarketViewAll() {

    }

    /**
     * @param username
     * @return
     */
    @Override
    public List<CoinDto> getAllCoinsIOwn(String username) {
        return null;
    }

    /// CLI
    public List<Coin> getAllCoinsCLI() {
        return coinsRepository.findAll();
    }

    public void updateCoinCLI(Coin removeCoin) {
        coinsRepository.save(removeCoin);
    }

    public Coin getCoinCLI(int val) {
        return coinsRepository.findById(val).get();
    }

    public void createCoinCLI(Coin createdCoin) {
        coinsRepository.save(createdCoin);
    }
}
