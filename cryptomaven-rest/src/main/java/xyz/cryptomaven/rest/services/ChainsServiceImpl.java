package xyz.cryptomaven.rest.services;


import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.Transactional;
import xyz.cryptomaven.rest.models.dto.ChainDto;
import xyz.cryptomaven.rest.exception.ResourceNotFoundException;
import xyz.cryptomaven.rest.models.Chain;
import xyz.cryptomaven.rest.mapper.ChainMapper;
import xyz.cryptomaven.rest.repositories.ChainsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Primary
@Service
public class ChainsServiceImpl implements ChainsService {

private final ChainsRepository chainsRepository;

private final ChainMapper chainMapper;

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
    @Transactional(readOnly=true)
    @Override
    public   ChainDto getChain(Long id) {
        Chain chain = chainsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ChainById", "NOT_FOUND", Long.toString(id)));
            return chainMapper.toOneDto(chain);
    }
    /**
     * @return List<ChainDto>
     */
    @Transactional(readOnly=true)
    @Override
    public List<ChainDto> getAllChains() {
        List<Chain> chains = chainsRepository.findAll();

      return chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());
    }

    /**
     * @return ChainDto
     */
    @Transactional(readOnly=true)
    @Override
    public  ChainDto  getChainByName(String name) {

      assert chainsRepository != null;
      Optional<Chain> c = chainsRepository.findByName(name);
      assert chainMapper != null;
      return chainMapper.toOneDto(c.orElse(null));
    }

    public ChainDto updateChain(ChainDto change) {
        try {
            Chain chainUpdate = chainMapper.toEntity(change);

          assert chainsRepository != null;
            chainUpdate = chainsRepository.findById(Long.valueOf(change.getId())).get();
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
    public   boolean deleteChain(Long id) {
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
