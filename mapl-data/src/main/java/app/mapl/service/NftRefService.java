package app.mapl.service;

import app.mapl.models.dto.NftRefDto;

import java.util.List;

public interface NftRefService {
    NftRefDto createNftRef(NftRefDto c);

    NftRefDto getNftRef(int id) ;

    List<NftRefDto> getAllNftRefsIOwn(String username);

    List<NftRefDto> getAllNftRefs();

    boolean updateNftRef(NftRefDto change);

    boolean deleteNftRef(int id) ;

}
