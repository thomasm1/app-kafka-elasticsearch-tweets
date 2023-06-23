package app.mapl.service;


import app.mapl.dto.ChainDto;

import java.util.List;


public interface ChainsService {


    ChainDto createChain(ChainDto cd);

    public ChainDto getChain(int chainId);

//    public List<Chain> getAllChainsIOwn(String username);

    public List<ChainDto> getAllChains();

    ChainDto  getChainByName(String name);

    public ChainDto updateChain(ChainDto change);

    public boolean deleteChain(int id);



}
