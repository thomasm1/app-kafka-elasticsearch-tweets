package app.mapl.service;


import app.mapl.models.dto.ChainDto;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.models.Chain;
import app.mapl.mapper.ChainMapper;
import app.mapl.repositories.ChainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChainsServiceImpl implements ChainsService {

private final ChainsRepository chainsRepository;

private final ChainMapper chainMapper;
public ChainsServiceImpl() {
        chainsRepository = null;
        chainMapper = null;
}
    public ChainsServiceImpl(ChainsRepository chainsRepository, ChainMapper chainMapper) {
        this.chainsRepository = chainsRepository;
        this.chainMapper = chainMapper;
    }


    /**
     * @param cd
     * @return ChainDto
     */
    @Override
    public   ChainDto createChain(ChainDto cd) {

        Chain chain = chainMapper.toEntity(cd);
        Chain newChain = chainsRepository.save(chain);

        ChainDto newChainDto = chainMapper.toOneDto(newChain);
        return newChainDto;
    }

    @Override
    public   ChainDto getChain(int id) {
        Chain chain = chainsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", Integer.toString(id)));
            return chainMapper.toOneDto(chain);
    }
    /**
     * @return List<ChainDto>
     */
    @Override
    public List<ChainDto> getAllChains() {
        List<Chain> chains = chainsRepository.findAll();
        List<ChainDto> content = chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());

        return content;
    }

    /**
     * @return ChainDto
     */
    @Override
    public  ChainDto  getChainByName(String name) {

        Chain c = chainsRepository.findByName(name);
        return chainMapper.toOneDto(c);
    }

    public ChainDto updateChain(ChainDto change) {
        try {
            Chain chainUpdate = chainMapper.toEntity(change);

            chainUpdate = chainsRepository.findById(change.getId()).get();
            chainUpdate.setName(change.getName());
            chainUpdate.setSymbol(change.getSymbol());
            chainUpdate.setDescription(change.getDescription());
            chainUpdate.setLongDescription(change.getLongDescription());
            chainUpdate.setChainListIcon(change.getChainListIcon());
            chainUpdate.setChainId(change.getChainId());
            chainUpdate.setCategory(change.getCategory());
            chainUpdate.setRpcUrl(change.getRpcUrl());
            chainUpdate.setIconUrl(change.getIconUrl());
            chainUpdate.setBlockExplorerUrl(change.getBlockExplorerUrl());

            Chain chainDone = chainsRepository.save(chainUpdate);

            return chainMapper.toOneDto(chainDone);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    @Override
    public   boolean deleteChain(int id) {
        try {
            chainsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void createChainCLI(ChainDto createdChain) {
        Chain chain = chainMapper.toEntity(createdChain);
        chainsRepository.save(chain);
    }

    public List<Chain> getChains() {
        return chainsRepository.findAll();
    }

    public List<Chain> getAllChainsCustCLI() {
        return chainsRepository.findAll();
    }
}
