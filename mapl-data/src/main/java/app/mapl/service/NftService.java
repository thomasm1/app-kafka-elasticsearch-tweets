package app.mapl.service;

import app.mapl.models.dto.NftDto;

import java.util.List;

public interface NftService {
    boolean createNft(NftDto c);

    NftDto getNft(int id) ;

    List<NftDto> getAllNftsIOwn(String username);

    List<NftDto> getAllNfts();

    boolean updateNft(NftDto change);

    boolean deleteNft(int id) ;

    void nftlotViewAll();
}
