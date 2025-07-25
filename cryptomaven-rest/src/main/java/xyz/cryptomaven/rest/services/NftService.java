package xyz.cryptomaven.rest.services;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import xyz.cryptomaven.rest.models.dto.NftCoinDto;

import java.util.List;
import java.util.Optional;

public interface NftService {
  @Nullable
  NftCoinDto createNft(@NonNull NftCoinDto nftCoinDto);

  Optional<NftCoinDto> getNft(Long id);

  List<NftCoinDto> getAllNFTs();

  boolean updateNft(NftCoinDto nftCoinDto);

  boolean deleteNft(Long id);

  void nftlotViewAll();
}