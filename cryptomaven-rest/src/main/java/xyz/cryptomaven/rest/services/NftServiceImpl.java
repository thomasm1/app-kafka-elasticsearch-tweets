package xyz.cryptomaven.rest.services;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.cryptomaven.rest.models.Attribute;
import xyz.cryptomaven.rest.models.Coin;
import xyz.cryptomaven.rest.models.Metadata;
import xyz.cryptomaven.rest.models.NftCoin;
import xyz.cryptomaven.rest.models.dto.AttributeDto;
import xyz.cryptomaven.rest.models.dto.MetadataDto;
import xyz.cryptomaven.rest.models.dto.NftCoinDto;
import xyz.cryptomaven.rest.repositories.AttributeRepository;
import xyz.cryptomaven.rest.repositories.CoinRepository;
import xyz.cryptomaven.rest.repositories.MetadataRepository;
import xyz.cryptomaven.rest.repositories.NftRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NftServiceImpl implements NftService {

    @Autowired
    private NftRepository nftRepository;

    @Autowired
    private MetadataRepository metadataRepository;

    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private CoinRepository coinRepository;

    @Override
    public Optional<NftCoinDto> getNft(Long id) {
        return nftRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public List<NftCoinDto> getAllNFTs() {
        return nftRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public @Nullable NftCoinDto createNft(@NonNull NftCoinDto nftCoinDto) {
        NftCoin nftCoin = convertToEntity(nftCoinDto);

        // Save Metadata first
        Metadata metadata = nftCoin.getMetadata();
        if (metadata != null) {
            metadata = metadataRepository.save(metadata);
            nftCoin.setMetadata(metadata);
        }

        // Save Attributes
        if (metadata != null && metadata.getAttributes() != null) {
            for (Attribute attribute : metadata.getAttributes()) {
                attribute.setMetadata(metadata);
                attributeRepository.save(attribute);
            }
        }

        // Save Coin
        if (nftCoin.getCoin() != null) {
            Coin coin = coinRepository.save(nftCoin.getCoin());
            nftCoin.setCoin(coin);
        }
        // Save NftCoin
        nftCoin = nftRepository.save(nftCoin);
        return convertToDto(nftCoin);
    }

    @Override
    public boolean updateNft(NftCoinDto nftCoinDto) {
        Optional<NftCoin> existingNft = nftRepository.findById(nftCoinDto.getId());
        if (existingNft.isPresent()) {
            NftCoin nftCoin = existingNft.get();
            nftCoin.setName(nftCoinDto.getName());
            nftCoin.setAmount(nftCoinDto.getAmount());

            // Update Metadata
            Metadata metadata = nftCoin.getMetadata();
            if (metadata != null) {
                MetadataDto metadataDto = nftCoinDto.getMetadata();
                if (metadataDto != null) {
                    metadata.setName(metadataDto.getName());
                    metadata.setDescription(metadataDto.getDescription());
                    metadata.setImage(metadataDto.getImage());
                    metadata.setExternal_url(metadataDto.getExternal_url());
                    metadataRepository.save(metadata);
                }
                // Update Attributes
                if (metadata.getAttributes() != null) {
                    assert nftCoinDto.getMetadata() != null;
                    List<AttributeDto> attributeDtos = nftCoinDto.getMetadata().getAttributes();
                    if (attributeDtos != null) {
                        for (int i = 0; i < metadata.getAttributes().size(); i++) {
                            Attribute attribute = metadata.getAttributes().get(i);
                            AttributeDto attributeDto = attributeDtos.get(i);
                            attribute.setAttribute_value(attributeDto.getAttribute_value());
                            attribute.setTrait_type(attributeDto.getTrait_type());
                            attributeRepository.save(attribute);
                        }
                    }
                }
            }
            // Update Coin
            if (nftCoin.getCoin() != null) {
                Coin coin = coinRepository.save(nftCoin.getCoin());
                nftCoin.setCoin(coin);
            }
            nftRepository.save(nftCoin);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteNft(Long id) {
        if (nftRepository.existsById(id)) {
            nftRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void nftlotViewAll() {
        // You can implement this method if you need it.
    }

    private NftCoinDto convertToDto(NftCoin nftCoin) {
        NftCoinDto nftCoinDto = new NftCoinDto();
        nftCoinDto.setId(nftCoin.getId());
        nftCoinDto.setName(nftCoin.getName());
        nftCoinDto.setAmount(nftCoin.getAmount());

        if (nftCoin.getMetadata() != null) {
            MetadataDto metadataDto = new MetadataDto();
            metadataDto.setMetadataId(nftCoin.getMetadata().getId());
            metadataDto.setName(nftCoin.getMetadata().getName());
            metadataDto.setDescription(nftCoin.getMetadata().getDescription());
            metadataDto.setImage(nftCoin.getMetadata().getImage());
            metadataDto.setExternal_url(nftCoin.getMetadata().getExternal_url());
            if (nftCoin.getMetadata().getAttributes() != null) {
                List<AttributeDto> attributeDtos = nftCoin.getMetadata().getAttributes().stream()
                        .map(this::convertToAttributeDto)
                        .collect(Collectors.toList());
                metadataDto.setAttributes(attributeDtos);
            }
            nftCoinDto.setMetadata(metadataDto);
        }
        return nftCoinDto;
    }

    private NftCoin convertToEntity(NftCoinDto nftCoinDto) {
        NftCoin nftCoin = new NftCoin();
        nftCoin.setId(nftCoinDto.getId());
        nftCoin.setName(nftCoinDto.getName());
        nftCoin.setAmount(nftCoinDto.getAmount());

        if (nftCoinDto.getMetadata() != null) {
            Metadata metadata = new Metadata();
            metadata.setId((long) nftCoinDto.getMetadata().getMetadataId());
            metadata.setName(nftCoinDto.getMetadata().getName());
            metadata.setDescription(nftCoinDto.getMetadata().getDescription());
            metadata.setImage(nftCoinDto.getMetadata().getImage());
            metadata.setExternal_url(nftCoinDto.getMetadata().getExternal_url());
            if (nftCoinDto.getMetadata().getAttributes() != null) {
                List<Attribute> attributes = nftCoinDto.getMetadata().getAttributes().stream()
                        .map(this::convertToAttributeEntity)
                        .collect(Collectors.toList());
                metadata.setAttributes(attributes);
            }
            nftCoin.setMetadata(metadata);
        }
        return nftCoin;
    }

    private AttributeDto convertToAttributeDto(Attribute attribute) {
        AttributeDto attributeDto = new AttributeDto();
        attributeDto.setAttrid(attribute.getAttrid());
        attributeDto.setAttribute_value(attribute.getAttribute_value());
        attributeDto.setTrait_type(attribute.getTrait_type());
        return attributeDto;
    }

    private Attribute convertToAttributeEntity(AttributeDto attributeDto) {
        Attribute attribute = new Attribute();
        attribute.setAttrid((long) attributeDto.getAttrid());
        attribute.setAttribute_value(attributeDto.getAttribute_value());
        attribute.setTrait_type(attributeDto.getTrait_type());
        return attribute;
    }
}
