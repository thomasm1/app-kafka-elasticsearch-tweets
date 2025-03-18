package xyz.cryptomaven.rest.services;

import xyz.cryptomaven.rest.models.NftCoin;
import xyz.cryptomaven.rest.models.dto.NftCoinDto;
import xyz.cryptomaven.rest.exception.ResourceNotFoundException;
import xyz.cryptomaven.rest.mapper.NftMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xyz.cryptomaven.rest.repositories.NftRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NftServiceImpl implements NftService {

    private static final Logger log = LoggerFactory.getLogger(NftServiceImpl.class);
    private final NftRepository nftRepository;
    private final NftMapper nftMapper;

    public NftServiceImpl(NftRepository nftRepository, NftMapper nftMapper) {
        this.nftRepository = nftRepository;
        this.nftMapper = nftMapper;
    }

    public NftCoinDto createNft(NftCoinDto nftCoinDto) {
        NftCoin coin = nftMapper.toEntity(nftCoinDto);
//    if (coin != null && (coin.getChainId() == 0)) {
//        coin.setChainId(nftCoinDto.getChainId());
//    }
        NftCoin newCoin = nftRepository.save(coin);
        NftCoinDto newNftCoinDto = nftMapper.toDto(newCoin);
        return newNftCoinDto;
    }


    public NftCoinDto getNft(Long id) {
        NftCoin coin = nftRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", Long.toString(id)));
        return nftMapper.toDto(coin);
    }

    public List<NftCoinDto> getAllNFTsByName(String name) {
        List<NftCoin> coins = nftRepository.findAll();
        List<NftCoinDto> content = coins.stream().map(nftMapper::toDto).collect(Collectors.toList());
    return content;

    }

    public List<NftCoinDto> getAllNFTs() {
        List<NftCoin> adds = nftRepository.findAll();
        List<NftCoinDto> nftCoinDtos = adds.stream().map(nftMapper::toDto).collect(Collectors.toList());
        return nftCoinDtos;
    }


    public boolean updateNft(NftCoinDto change) {
        try {
            NftCoin coin = nftMapper.toEntity(change);
            NftCoin newCoin = nftRepository.save(coin);
            NftCoinDto newNftCoinDto = nftMapper.toDto(newCoin);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteNft(Long id) {
  try {
            nftRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
  }

    public void nftlotViewAll() {
    }
}
