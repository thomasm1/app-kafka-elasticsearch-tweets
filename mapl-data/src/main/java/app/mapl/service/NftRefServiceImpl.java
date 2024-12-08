package app.mapl.service;

import app.mapl.models.dto.NftRefDto;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.mapper.NftRefMapper;
import app.mapl.models.NftRef;
import app.mapl.repositories.NftRefRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NftRefServiceImpl implements NftRefService {

    private static final Logger log = LoggerFactory.getLogger(NftRefServiceImpl.class);
    private final NftRefRepository nftRefRepository;
    private final NftRefMapper nftRefMapper;

    public NftRefServiceImpl(NftRefRepository nftRefRepository, NftRefMapper nftRefMapper) {
        this.nftRefRepository = nftRefRepository;
        this.nftRefMapper = nftRefMapper;
    }

    public NftRefDto createNftRef(NftRefDto nftRefDto) {
        NftRef nftRef = nftRefMapper.toEntity(nftRefDto);

//    if (nftRef != null && (nftRef.getChainId() == 0)) {
//        nftRef.setChainId(nftRefDto.getChainId());
//    }

        NftRef newNftRef = nftRefRepository.save(nftRef);
        NftRefDto newNftRefDto = nftRefMapper.toDto(newNftRef);
        return newNftRefDto;
    }

    public NftRefDto getNftRef(int id) {
        NftRef nftRef = nftRefRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", Integer.toString(id)));
        return nftRefMapper.toDto(nftRef);
    }

    public List<NftRefDto> getAllNftRefsIOwn(String username) {
        List<NftRef> nftRefs = nftRefRepository.findAll();
        List<NftRefDto> content = nftRefs.stream().map(nftRefMapper::toDto).collect(Collectors.toList());
    return content;
    }

    public List<NftRefDto> getAllNftRefs() {
        List<NftRef> adds = nftRefRepository.findAll();
        List<NftRefDto> nftRefDtos = adds.stream().map(nftRefMapper::toDto).collect(Collectors.toList());
        return nftRefDtos;
    }


    public boolean updateNftRef(NftRefDto change) {
        try {
            NftRef nftRef = nftRefMapper.toEntity(change);
            NftRef newNftRef = nftRefRepository.save(nftRef);
            NftRefDto newNftRefDto = nftRefMapper.toDto(newNftRef);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteNftRef(int id) {
  try {
            nftRefRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
  }

}
