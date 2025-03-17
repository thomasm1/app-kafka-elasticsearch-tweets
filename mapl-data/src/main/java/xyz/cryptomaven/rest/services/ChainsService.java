package xyz.cryptomaven.rest.services;


import xyz.cryptomaven.rest.models.dto.ChainDto;

import java.util.List;


public interface ChainsService {


    ChainDto createChain(ChainDto cd);

    ChainDto getChain(Long id);

    //    @Autowired
    //    public List<Chain> getAllChainsIOwn(String username) {
    //        return null; //(List<Chain>)  chainsRepository.findByUsername(username);
    //    }
    List<ChainDto> getAllChains();


    ChainDto  getChainByName(String name);

    ChainDto updateChain(ChainDto change);

    boolean deleteChain(Long id);

    void createChainCLI(ChainDto createdChain);
}
