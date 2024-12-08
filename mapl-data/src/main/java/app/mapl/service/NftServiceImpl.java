package app.mapl.service;

import app.mapl.models.dto.NftDto;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.mapper.NftMapper;
import app.mapl.models.Nft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import app.mapl.repositories.NftRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NftServiceImpl implements NftService {

    private static final Logger log = LoggerFactory.getLogger(NftServiceImpl.class);
    private final NftRepository nftRepository;
    private final NftMapper nftMapper;

    public NftServiceImpl(NftRepository nftRepository, NftMapper nftMapper) {
        this.nftRepository = nftRepository;
        this.nftMapper = nftMapper;
    }

    public boolean createNft(NftDto nftDto) {
        Nft nft = nftMapper.toEntity(nftDto);

//    if (nft != null && (nft.getChainId() == 0)) {
//        nft.setChainId(nftDto.getChainId());
//    }

        Nft newNft = nftRepository.save(nft);
        NftDto newNftDto = nftMapper.toDto(newNft);
        return true;
    }

    public NftDto getNft(int id) {
        Nft nft = nftRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", Integer.toString(id)));
        return nftMapper.toDto(nft);
    }

    public List<NftDto> getAllNftsIOwn(String username) {
        List<Nft> nfts = nftRepository.findAll();
        List<NftDto> content = nfts.stream().map(nftMapper::toDto).collect(Collectors.toList());
    return content;

    }

    public List<NftDto> getAllNfts() {
        List<Nft> adds = nftRepository.findAll();
        List<NftDto> nftDtos = adds.stream().map(nftMapper::toDto).collect(Collectors.toList());
        return nftDtos;
    }


    public boolean updateNft(NftDto change) {
        try {
            Nft nft = nftMapper.toEntity(change);
            Nft newNft = nftRepository.save(nft);
            NftDto newNftDto = nftMapper.toDto(newNft);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteNft(int id) {
  try {
            nftRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
  }

    public void nftlotViewAll() {
    }
}
