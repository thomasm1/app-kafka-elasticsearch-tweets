package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.models.dto.NftAddressDto;
import com.friendsofgroot.app.models.NftAddress;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {RawTokenMapper.class, NftMapper.class})
public interface NftAddressMapper {
    NftAddress toEntity(NftAddressDto nftAddressDto);

    NftAddressDto toDto(NftAddress nftAddress);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NftAddress partialUpdate(NftAddressDto nftAddressDto, @MappingTarget NftAddress nftAddress);

    @AfterMapping
    default void linkRawTokens(@MappingTarget NftAddress nftAddress) {
        nftAddress.getRawTokens().forEach(rawToken -> rawToken.setNftAddress(nftAddress));
    }

//    @AfterMapping
//    default void linkNfts(@MappingTarget NftAddress nftAddress) {
//        nftAddress.getNfts().forEach(nft -> nft.setNftAddress(nftAddress));
//    }
}
