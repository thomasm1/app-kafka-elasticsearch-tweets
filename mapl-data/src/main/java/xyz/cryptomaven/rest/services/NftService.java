package xyz.cryptomaven.rest.services;

import xyz.cryptomaven.rest.models.dto.NftCoinDto;

import java.util.List;

public interface NftService {
  NftCoinDto createNft(NftCoinDto c);

    NftCoinDto getNft(Long id) ;

    List<NftCoinDto> getAllNFTsByName(String name);

    List<NftCoinDto> getAllNFTs();

    boolean updateNft(NftCoinDto change);

    boolean deleteNft(Long id) ;

    void nftlotViewAll();
}
