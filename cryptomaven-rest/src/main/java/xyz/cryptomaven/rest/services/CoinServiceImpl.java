package xyz.cryptomaven.rest.services;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.cryptomaven.rest.exception.ResourceNotFoundException;
import xyz.cryptomaven.rest.mapper.CoinMapper;
import xyz.cryptomaven.rest.models.Coin;
import xyz.cryptomaven.rest.models.dto.CoinDto;
import xyz.cryptomaven.rest.repositories.CoinRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Service
public class CoinServiceImpl implements CoinService {

private final CoinRepository coinRepository;

private final CoinMapper coinMapper;

    public CoinServiceImpl(CoinRepository coinRepository, CoinMapper coinMapper) {
        this.coinRepository = coinRepository;
        this.coinMapper = coinMapper;
    }


    /**
     * @param
     * @return CoinDto
     */
    @Override
    public   CoinDto createCoin(CoinDto cd) {

       Coin coin = coinMapper.toEntity(cd);
        Coin newCoin = coinRepository.save(coin);

        CoinDto newCoinDto = coinMapper.toDto(newCoin);
        return newCoinDto;
    }

    /**
     * @return List<CoinDto>
     */
    @Transactional(readOnly=true)
    @Override
    public List<CoinDto> getAllCoin() {
        List<Coin> coin = coinRepository.findAll();

      return coin.stream().map(coinMapper::toDto).collect(Collectors.toList());
    }

    /**
     * @return CoinDto
     */
    @Transactional(readOnly=true)
    @Override
    public Optional<CoinDto>  getCoinById(Long id) {

      assert coinRepository != null;
      Optional<Coin> c = coinRepository.findById(id);
      CoinDto coinDto =  coinMapper.toDto(c.orElse(null));
      return Optional.ofNullable(coinDto);
    }

    public CoinDto updateCoin(CoinDto change) {
        try {
            Coin coinUpdate = coinMapper.toEntity(change);

          assert coinRepository != null;
            coinUpdate = coinRepository.findById(Long.valueOf(change.getId())).get();

            Coin coinDone = coinRepository.save(coinUpdate);

            return coinMapper.toDto(coinDone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @Override
    public   boolean deleteCoin(Long id) {
        try {
            coinRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void createCoinCLI(CoinDto createdCoin) {
        Coin coin = coinMapper.toEntity(createdCoin);
        coinRepository.save(coin);
    }

    public List<Coin> getCoin() {
        return coinRepository.findAll();
    }

    public List<Coin> getAllCoinCustCLI() {
        return coinRepository.findAll();
    }
}
