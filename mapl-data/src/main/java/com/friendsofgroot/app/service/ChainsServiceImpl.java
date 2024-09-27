package com.friendsofgroot.app.service;


import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.models.Chain;
import com.friendsofgroot.app.mapper.ChainMapper;
//import com.friendsofgroot.app.models.dto.Symbol;
import com.friendsofgroot.app.repositories.ChainsRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static org.springframework.beans.support.PagedListHolder.DEFAULT_PAGE_SIZE;

@Service
@Primary
public class ChainsServiceImpl implements ChainsService {

    private static final Logger log = LoggerFactory.getLogger(ChainsServiceImpl.class);
    private static final int DEFAULT_PAGE =0 ;
    private final ChainsRepository chainsRepository;

    private final ChainMapper chainMapper;


    public ChainsServiceImpl(ChainsRepository chainsRepository, ChainMapper chainMapper) {
        this.chainsRepository = chainsRepository;
        this.chainMapper = chainMapper;

        Chain chain1 = Chain.builder()
                .chainId((int) Math.floor(Math.random()*31))
                .name("Ethereum")
                .symbol("ETH")
                .chainListIcon("https://www.cryptocompare.com/media/37746251/eth.png")
                .rpcUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                .blockExplorerUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                .longDescription("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                .description("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                .iconUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                .build();

        Chain chain2 = Chain.builder()
                .chainId((int) Math.floor(Math.random()*31))
                .name("Bitcoin")
                .symbol("BTC")
                        .chainListIcon("https://www.cryptocompare.com/media/37746251/eth.png")
                        .rpcUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                        .blockExplorerUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                        .longDescription("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                        .description("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                        .iconUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                        .build();

        Chain chain3 = Chain.builder()
                .chainId((int) Math.floor(Math.random()*31))
                .name("PulseChain")
                .symbol("PLS")
                .chainListIcon("https://www.cryptocompare.com/media/37746251/eth.png")
                .rpcUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                .blockExplorerUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                .longDescription("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                .description("Ethereum is a decentralized platform that runs smart contracts: applications that run exactly as programmed without any possibility of downtime, censorship, fraud or third-party interference.")
                .iconUrl("https://www.cryptocompare.com/media/37746251/eth.png")
                .build();

//        Chain newChain = chainsRepository.save(chain1);
//        Chain newChain2 = chainsRepository.save(chain2);
//        Chain newChain3 = chainsRepository.save(chain3);


    }

    /**
     * @return
     */

    @Override
    public ChainDto saveNewChain(ChainDto chainDto) {
        ChainDto savedChain = ChainDto.builder()
                .chainId((int) Math.floor(Math.random()*31))
//                .dateCreated(Date.from(java.time.ZonedDateTime.now().toInstant()))
//                .createdDate(LocalDateTime.now())
                .build();

        Chain chain = chainMapper.toEntity(chainDto);
        Chain newChain = chainsRepository.save(chain);

        ChainDto newChainDto = chainMapper.toOneDto(newChain);
        return newChainDto;
    }



    @Override
    public Optional<ChainDto> getChainByChainId(Integer chainId) {
        log.debug("Get Chain by Id - in service. Id: " + chainId.toString());
        Chain chain = chainsRepository.findById(chainId).orElseThrow(() -> new ResourceNotFoundException("not found", "not found",chainId.toString()));
        return Optional.of(chainMapper.toOneDto(chainsRepository.findChainByChainId(chainId))); //
    }

//    @Autowired
//    public List<Chain> getAllChainsIOwn(String username) {
//        return null; //(List<Chain>)  chainsRepository.findByUsername(username);
//    }

//    /**
//     * @return
//     */
//    @Override
//    public List<ChainDto> findByCategory(String cat) {
//        List<Chain> chains = chainsRepository.findByCategory(cat);
//        List<ChainDto> content = chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());
//        return content;
//    }

    /**
     * @param name
     * @return
     */
    @Override
    public List<ChainDto> findByName(String name) {
        List<Chain> chains = chainsRepository.findByName(name);
        List<ChainDto> content = chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());
        return content;
    }
    @Override
    public List<ChainDto> getAllChains() {
        List<Chain> chains = chainsRepository.findAll();

        List<ChainDto> content = new ArrayList<>();
    if(chains != null) {
        log.info(chains.size() + " chains_______________");
        try {
            content =  chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());
            log.info(content.toString());

        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
        log.info(content.size() + " chainDTO_______________");
        return content;
    }

    @Override
    public Page<ChainDto> getAllChainsPageable(Pageable page) {
        Page<Chain> chains = chainsRepository.findAll(page);
        Page<ChainDto> content = (Page<ChainDto>) chains.stream().map(chainMapper::toOneDto).collect(Collectors.toList());

        return content;
    }

    @Override
    public Page<ChainDto> listChains(String name, String symbol,  Integer pageNumber, Integer pageSize){


        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize);
        Page<Chain> chainPage;
        if(StringUtils.hasText(name) && symbol == null) {
            chainPage = listChainsByName(name, pageRequest);
        } else if (!StringUtils.hasText(name) && symbol != null){
            chainPage = listChainsBySymbol(symbol, pageRequest); //, pageRequest);
        } else if (StringUtils.hasText(name) && symbol != null){
            chainPage = listChainsByNameAndSymbol(name, symbol, pageRequest);
        } else {
            chainPage = chainsRepository.findAll(pageRequest);
        }
        return chainPage.map(chainMapper::toOneDto);

    }
    public  Page<Chain>  listChainsByNameAndSymbol(String name, String symbol, Pageable  pageable) {
        return chainsRepository.findAllByNameIsLikeIgnoreCaseAndSymbol("%" + name + "%",
                symbol, pageable);
    }

    public Page<Chain>  listChainsByName(String name, Pageable pageable) {
        return chainsRepository.findAllByNameIsLikeIgnoreCase("%" + name + "%", pageable);
    }

    private Page<Chain>  listChainsBySymbol(String symbol, Pageable pageable) {

        return chainsRepository.findAllBySymbol(symbol, pageable);
   }

    @Override
    public ChainDto getChainByName(String name) {

        List<Chain> c = chainsRepository.findByName(name);
        return (ChainDto) chainMapper.toListDto(c);
    }

    @Override
    public ChainDto updateChain(ChainDto change) {
        return null;
    }


    @Override
    public Optional<ChainDto> updateChainByChainId(Integer chainId, ChainDto change) {
        AtomicReference<Optional<ChainDto>> atomicReference = new AtomicReference<>();

             chainsRepository.findById(chainId).ifPresentOrElse(chainUpdate -> {
                if (StringUtils.hasText(change.getName())) {
                    chainUpdate.setName(change.getName());
                }
                if (StringUtils.hasText(String.valueOf(change.getSymbol()))) {
                    chainUpdate.setSymbol(change.getSymbol());
                }
                if (StringUtils.hasText(change.getDescription())) {
                    chainUpdate.setDescription(change.getDescription());
                }
                if (StringUtils.hasText(change.getLongDescription())) {
                    chainUpdate.setLongDescription(change.getLongDescription());
                }
                if (StringUtils.hasText(change.getChainListIcon())) {
                    chainUpdate.setChainListIcon(change.getChainListIcon());
                }
                if (StringUtils.hasText(change.getRpcUrl())) {
                    chainUpdate.setRpcUrl(change.getRpcUrl());
                }
                if (StringUtils.hasText(change.getIconUrl())) {
                    chainUpdate.setIconUrl(change.getIconUrl());
                }
                if (StringUtils.hasText(change.getBlockExplorerUrl())) {
                    chainUpdate.setBlockExplorerUrl(change.getBlockExplorerUrl());
                }
//                chainUpdate.setVersion(chainUpdate.getVersion() + 1);
                Chain chainDone = chainsRepository.save(chainUpdate);
                atomicReference.set(Optional.of(chainMapper.toOneDto(chainDone)));
            }, () -> {
                atomicReference.set(Optional.empty());
             });

        return atomicReference.get();
    }


    @Override
    public Optional<ChainDto> patchChainById(Integer chainId, ChainDto chain) {

        Chain chainUpdate = chainsRepository.findById(chainId).get();
        if (StringUtils.hasText(chain.getName())) {
            chainUpdate.setName(chain.getName());
        }

        if (chain.getSymbol() != null) {
            chainUpdate.setSymbol(chain.getSymbol());
        }
        if (StringUtils.hasText(chain.getDescription())) {
            chainUpdate.setDescription(chain.getDescription());
        }
        if (StringUtils.hasText(chain.getLongDescription())) {
            chainUpdate.setLongDescription(chain.getLongDescription());
        }
        if (StringUtils.hasText(chain.getChainListIcon())) {
            chainUpdate.setChainListIcon(chain.getChainListIcon());
        }
        if (StringUtils.hasText(chain.getRpcUrl())) {
            chainUpdate.setRpcUrl(chain.getRpcUrl());
        }
        if (StringUtils.hasText(chain.getIconUrl())) {
            chainUpdate.setIconUrl(chain.getIconUrl());
        }
        if (StringUtils.hasText(chain.getBlockExplorerUrl())) {
            chainUpdate.setBlockExplorerUrl(chain.getBlockExplorerUrl());
        }
        Chain chainDone = chainsRepository.save(chainUpdate);

        return Optional.of(chainMapper.toOneDto(chainDone));
    }

    @Override
    public boolean deleteById(Integer chainId) {
        if (chainsRepository.existsById(chainId)) {
            chainsRepository.deleteById(chainId);
            return true;
        }
            return false;

    }

    public PageRequest buildPageRequest(Integer pageNumber, Integer pageSize) {
        int queryPageNumber;
        int queryPageSize;

        if (pageNumber != null && pageNumber > 0) {
            queryPageNumber = pageNumber - 1;
        } else {
            queryPageNumber = DEFAULT_PAGE;
        }

        if (pageSize == null) {
            queryPageSize = DEFAULT_PAGE_SIZE;
        } else {
            if (pageSize > 1000) {
                queryPageSize = 1000;
            } else {
                queryPageSize = pageSize;
            }
        }

        Sort sort = Sort.by(Sort.Order.asc("name"));

        return PageRequest.of(queryPageNumber, queryPageSize, sort);
    }
}
