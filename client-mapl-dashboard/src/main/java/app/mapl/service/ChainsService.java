package app.mapl.service;


import app.mapl.models.Chain;
import app.mapl.models.dto.ChainDto;

import java.util.List;


public interface ChainsService {


    ChainDto createChain(ChainDto cd);

    ChainDto getChain(int id);

    //    @Autowired
    //    public List<Chain> getAllChainsIOwn(String username) {
    //        return null; //(List<Chain>)  chainsRepository.findByUsername(username);
    //    }
    List<ChainDto> getAllChains();


    ChainDto  getChainByName(String name);

    ChainDto updateChain(ChainDto change);

    boolean deleteChain(int id);
}
